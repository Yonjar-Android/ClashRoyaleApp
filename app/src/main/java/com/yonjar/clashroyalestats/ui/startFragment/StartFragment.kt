package com.yonjar.clashroyalestats.ui.startFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null

    private lateinit var bottomNavigation: BottomNavigationView
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStartBinding.inflate(inflater, container, false)

        bottomNavigation = requireActivity().findViewById(R.id.navMenu)
        bottomNavigation.visibility = View.INVISIBLE

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEnter.setOnClickListener {

            if(binding.edTag.text.isBlank()){
                binding.edTag.error = "This camp cannot be empty"
                return@setOnClickListener
            }

            val tagPlayer: String = binding.edTag.text.trim().toString().uppercase()

            findNavController().navigate(
                StartFragmentDirections.actionStartFragment2ToMainInfoFragment22(
                    tagPlayer
                )
            )
        }
    }

}