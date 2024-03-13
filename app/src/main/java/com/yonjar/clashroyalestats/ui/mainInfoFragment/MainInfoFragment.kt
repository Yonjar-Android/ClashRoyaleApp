package com.yonjar.clashroyalestats.ui.mainInfoFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.databinding.FragmentMainInfoBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainInfoFragment : Fragment() {

    private var _binding: FragmentMainInfoBinding? = null

    private lateinit var bottomNavigation: BottomNavigationView
    private val binding get() = _binding!!

    private val args:MainInfoFragmentArgs by navArgs()

    private val viewModel:MainInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainInfoBinding.inflate(inflater, container, false)

        bottomNavigation = requireActivity().findViewById(R.id.navMenu)
        bottomNavigation.visibility = View.VISIBLE

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println(args.tagPlayer)
        if (args.tagPlayer.isNotBlank()){ viewModel.chargePlayerInfo(args.tagPlayer)} else Toast.makeText(requireContext(),"An error has ocurred",Toast.LENGTH_SHORT).show()

        initUI()

    }

    private fun initUI(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.state.collectLatest { state ->
                    when(state){
                        is MainInfoState.Error -> funError(state)
                        MainInfoState.Loading -> funLoading()
                        is MainInfoState.Success -> funSuccess(state)
                    }
                }
            }
        }
    }

    private fun funSuccess(state: MainInfoState.Success) {

        Glide.with(requireContext()).load(state.playerInfo.favouriteCard).into(binding.ivFavCard)

        binding.tvName.text = state.playerInfo.userName

        binding.progressBar.visibility = View.GONE
    }

    private fun funLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun funError(state: MainInfoState.Error) {

        Toast.makeText(requireContext(), state.error, Toast.LENGTH_SHORT).show()

        binding.progressBar.visibility = View.GONE
    }

}