package com.yonjar.clashroyalestats.ui.mainInfoFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.databinding.FragmentMainInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainInfoFragment : Fragment() {

    private var _binding: FragmentMainInfoBinding? = null

    private lateinit var bottomNavigation: BottomNavigationView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainInfoBinding.inflate(inflater, container, false)

        bottomNavigation = requireActivity().findViewById(R.id.navMenu)
        bottomNavigation.visibility = View.VISIBLE

        return binding.root
    }

}