package com.yonjar.clashroyalestats.ui.startFragment

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
import com.yonjar.clashroyalestats.databinding.FragmentStartBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null

    private val binding get() = _binding!!

    private val viewModel: StartViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStartBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

        initListeners()

    }

    private fun initListeners() {
        binding.btnEnter.setOnClickListener {

            if(binding.edTag.text.isBlank()){
                binding.edTag.error = "This camp cannot be empty"
                return@setOnClickListener
            }

            val tagPlayer: String = binding.edTag.text.trim().toString().uppercase()

            viewModel.verifyPlayer(tagPlayer)

        }
    }

    private fun initUI(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.state.collectLatest {state ->
                    when(state){
                        is StartFragmentState.Error -> funError(state)
                        StartFragmentState.Loading -> funLoading()
                        is StartFragmentState.Success -> funSuccess(state)
                    }
                }
            }
        }
    }

    private fun funError(state: StartFragmentState.Error) {

        Toast.makeText(requireContext(), state.error , Toast.LENGTH_SHORT).show()

        binding.progressBar.visibility = View.GONE
        binding.whiteScreen!!.visibility = View.GONE

    }

    private fun funSuccess(state: StartFragmentState.Success) {

        if(state.playerTag.isBlank()) return

        Toast.makeText(requireContext(), "Player was found" , Toast.LENGTH_SHORT).show()



        findNavController().navigate(
            StartFragmentDirections.actionStartFragment2ToMainInfoFragment22(
                state.playerTag
            )
        )
        binding.progressBar.visibility = View.GONE
        binding.whiteScreen!!.visibility = View.GONE

    }

    private fun funLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.whiteScreen!!.visibility = View.VISIBLE
    }

}