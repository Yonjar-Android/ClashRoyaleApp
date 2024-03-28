package com.yonjar.clashroyalestats.ui.badgesFragment

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
import com.yonjar.clashroyalestats.databinding.FragmentBadgesBinding
import com.yonjar.clashroyalestats.ui.badgesFragment.recyclerView.RvBadgesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BadgesFragment : Fragment() {

    private var _binding: FragmentBadgesBinding? = null

    private val binding get() = _binding!!

    private lateinit var bottomNavigation: BottomNavigationView

    private val args: BadgesFragmentArgs by navArgs()

    private val viewModel: BadgesViewModel by viewModels()

    private lateinit var rvAdapter: RvBadgesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBadgesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.chargeBadges(args.tagPlayer)

        bottomNavigation = requireActivity().findViewById(R.id.navMenu)
        bottomNavigation.visibility = View.VISIBLE

        initUi()
        initListeners()
    }

    private fun initListeners() {
        bottomNavigation.setOnItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.mainInfoFragment2 -> {
                    findNavController().navigate(BadgesFragmentDirections.actionBadgesFragment2ToMainInfoFragment2(args.tagPlayer))
                    true
                }

                R.id.cardsFragment2 -> {
                    findNavController().navigate(BadgesFragmentDirections.actionBadgesFragment2ToCardsFragment2(args.tagPlayer))
                    true
                }

                R.id.chestFragment2 -> {
                    findNavController().navigate(BadgesFragmentDirections.actionBadgesFragment2ToChestFragment2(args.tagPlayer))
                    true
                }

                else -> { false   }
            }
        }
    }

    private fun initUi() {
        rvAdapter = RvBadgesAdapter(requireContext(), listOf()) { name, image, level -> toBadgeDetail(name, image, level)}

        binding.rvBadges.apply {
            adapter = rvAdapter
            layoutManager = GridLayoutManager(requireContext(),2)
        }


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.state.collectLatest { state ->
                    when(state){
                        is BadgesState.Error -> funError(state)
                        BadgesState.Loading -> funLoading()
                        is BadgesState.Success -> funSuccess(state)
                    }
                }
            }
        }
    }

    private fun funLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.whiteScreen.visibility = View.VISIBLE
    }

    private fun funSuccess(state: BadgesState.Success) {

        rvAdapter.updateList(state.badges)

        binding.progressBar.visibility = View.GONE
        binding.whiteScreen.visibility = View.GONE
    }

    private fun funError(state: BadgesState.Error) {

        Toast.makeText(requireContext(), state.error, Toast.LENGTH_SHORT).show()

        binding.progressBar.visibility = View.GONE
        binding.whiteScreen.visibility = View.GONE
    }

    private fun toBadgeDetail(name:String, image:String, level:Int){
        findNavController().navigate(BadgesFragmentDirections.actionBadgesFragment2ToBadgesDetailActivity(name, image, level))
    }

}