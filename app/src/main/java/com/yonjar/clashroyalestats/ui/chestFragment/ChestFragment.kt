package com.yonjar.clashroyalestats.ui.chestFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.databinding.FragmentChestBinding


class ChestFragment : Fragment() {

    private var _binding: FragmentChestBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentChestBinding.inflate(inflater, container, false)

        return binding.root
    }

}