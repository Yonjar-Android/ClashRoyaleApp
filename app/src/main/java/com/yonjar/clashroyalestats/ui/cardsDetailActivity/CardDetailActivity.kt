package com.yonjar.clashroyalestats.ui.cardsDetailActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.databinding.ActivityCardDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardDetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCardDetailBinding

    private val args:CardDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(args.cardImage.isNotBlank()){
            Glide.with(this).load(args.cardImage).into(binding.ivCard)
            binding.tvName.text = getString(R.string.strCardName, args.cardName)
            binding.tvLevel.text = getString(R.string.strCardLevel, args.cardLevel)
            binding.tvElixir.text = getString(R.string.strCardElixir, args.elixirCost)
            binding.tvRarity.text = getString(R.string.strCardRarity, args.cardRarity)
        } else{
            Toast.makeText(this,getText(R.string.unknownError), Toast.LENGTH_SHORT).show()
        }
    }

}