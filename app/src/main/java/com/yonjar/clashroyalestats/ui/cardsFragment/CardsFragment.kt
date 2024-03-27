package com.yonjar.clashroyalestats.ui.cardsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.databinding.FragmentCardsBinding
import com.yonjar.clashroyalestats.ui.cardsFragment.recyclerView.RvCardsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CardsFragment : Fragment() {

    private var _binding: FragmentCardsBinding? = null

    private val binding get() = _binding!!

    private val args:CardsFragmentArgs by navArgs()

    private val viewModel:CardsViewModel by viewModels()

    private lateinit var rvAdapter:RvCardsAdapter

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCardsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.chargeCards(args.tagPlayer)

        bottomNavigation = requireActivity().findViewById(R.id.navMenu)
        bottomNavigation.visibility = View.VISIBLE

        initUI()
        initListeners()

    }

    private fun initListeners() {
        bottomNavigation.setOnItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.mainStatsMenu -> {
                    findNavController().navigate(CardsFragmentDirections.actionCardsFragment2ToMainInfoFragment2(args.tagPlayer))
                    true
                }

                R.id.badgesMenu -> {
                    findNavController().navigate(CardsFragmentDirections.actionCardsFragment2ToBadgesFragment2(args.tagPlayer))
                    true
                }

                R.id.chestMenu -> {
                    findNavController().navigate(CardsFragmentDirections.actionCardsFragment2ToChestFragment2(args.tagPlayer))
                    true
                }

                else -> { false   }
            }
        }
    }

    private fun initUI() {
        rvAdapter = RvCardsAdapter(requireContext(), listOf()) {name, rarity, image, level, elixir -> navigateToDetail(name, rarity, image, level, elixir)}

        binding.rvCards.apply {
            adapter = rvAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
        }


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.state.collectLatest { state ->
                    when(state){
                        is CardsState.Error -> funError(state)
                        CardsState.Loading -> funLoading()
                        is CardsState.Success -> funSuccess(state)
                    }
                }
            }
        }
    }

    private fun funError(state: CardsState.Error) {

        Toast.makeText(requireContext(), state.error, Toast.LENGTH_SHORT).show()

        binding.progressBar.visibility = View.GONE
        binding.whiteScreen.visibility = View.GONE
    }

    private fun funLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.whiteScreen.visibility = View.VISIBLE
    }

    private fun funSuccess(state: CardsState.Success) {

        rvAdapter.updateList(state.playerCards)

        binding.progressBar.visibility = View.GONE
        binding.whiteScreen.visibility = View.GONE
    }

    private fun navigateToDetail(name:String, rarity:String, image:String, level:Int , elixir:Int){
        findNavController().navigate(CardsFragmentDirections.actionCardsFragment2ToCardDetailActivity(name,level,elixir,rarity,image))
    }


}