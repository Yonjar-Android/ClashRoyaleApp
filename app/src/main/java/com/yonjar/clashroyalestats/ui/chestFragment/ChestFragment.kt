package com.yonjar.clashroyalestats.ui.chestFragment

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
import com.yonjar.clashroyalestats.databinding.FragmentChestBinding
import com.yonjar.clashroyalestats.ui.chestFragment.recyclerView.RvChestAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChestFragment : Fragment() {

    private var _binding: FragmentChestBinding? = null

    private val binding get() = _binding!!

    private lateinit var bottomNavigation: BottomNavigationView

    private val args: ChestFragmentArgs by navArgs()

    private val viewModel: ChestViewModel by viewModels()

    private lateinit var rvAdapter:RvChestAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentChestBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigation = requireActivity().findViewById(R.id.navMenu)
        bottomNavigation.visibility = View.VISIBLE

        viewModel.chargeChestCycle(args.tagPlayer)

        initUi()
        initListeners()
    }

    private fun initListeners() {
        bottomNavigation.setOnItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.cardsFragment2 -> {
                    findNavController().navigate(ChestFragmentDirections.actionChestFragment2ToCardsFragment2(args.tagPlayer))
                    true
                }

                R.id.badgesFragment2 -> {
                    findNavController().navigate(ChestFragmentDirections.actionChestFragment2ToBadgesFragment2(args.tagPlayer))
                    true
                }

                R.id.mainInfoFragment2 -> {
                    findNavController().navigate(ChestFragmentDirections.actionChestFragment2ToMainInfoFragment2(args.tagPlayer))
                    true
                }

                else -> { false   }
            }
        }
    }

    private fun initUi() {
        rvAdapter = RvChestAdapter(requireContext(), listOf())

        binding.rvCards.apply {
            adapter = rvAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.state.collectLatest { state ->
                    when(state){
                        is ChestState.Error -> funError(state)
                        ChestState.Loading -> funLoading()
                        is ChestState.Success -> funSuccess(state)
                    }
                }
            }
        }
    }

    private fun funError(state: ChestState.Error) {

        Toast.makeText(requireContext(), state.error, Toast.LENGTH_SHORT).show()

        binding.whiteScreen.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
    }

    private fun funSuccess(state: ChestState.Success) {

        rvAdapter.updateList(state.chestList)

        binding.whiteScreen.visibility = View.GONE
        binding.progressBar.visibility = View.GONE
    }

    private fun funLoading() {
        binding.whiteScreen.visibility = View.VISIBLE
        binding.progressBar.visibility = View.VISIBLE
    }

}