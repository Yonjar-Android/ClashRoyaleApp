package com.yonjar.clashroyalestats.ui.cardsDetailActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.databinding.ActivityCardDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardDetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCardDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}