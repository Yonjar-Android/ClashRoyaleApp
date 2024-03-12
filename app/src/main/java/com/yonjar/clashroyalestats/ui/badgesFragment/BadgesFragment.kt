package com.yonjar.clashroyalestats.ui.badgesFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.databinding.FragmentBadgesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BadgesFragment : Fragment() {

    private var _binding: FragmentBadgesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBadgesBinding.inflate(inflater, container, false)

        return binding.root
    }


}