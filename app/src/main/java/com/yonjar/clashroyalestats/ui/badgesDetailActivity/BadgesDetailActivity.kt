package com.yonjar.clashroyalestats.ui.badgesDetailActivity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.databinding.ActivityBadgesDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BadgesDetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBadgesDetailBinding
    private val args: BadgesDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityBadgesDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if(args.badgeName.isNotBlank()){
            Glide.with(this).load(args.badgeImage).into(binding.ivBadge)
            binding.tvName.text = getString(R.string.strCardName, args.badgeName)
            binding.tvLevel.text = getString(R.string.strCardLevel, args.badgeLevel)
        } else{
            Toast.makeText(this,getText(R.string.unknownError), Toast.LENGTH_SHORT).show()
        }

    }
}