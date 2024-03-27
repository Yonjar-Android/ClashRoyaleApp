package com.yonjar.clashroyalestats.ui.cardsDetailActivity

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.databinding.ActivityCardDetailBinding
import com.yonjar.clashroyalestats.utils.RarityColor.COMMON
import com.yonjar.clashroyalestats.utils.RarityColor.EPIC
import com.yonjar.clashroyalestats.utils.RarityColor.LEGENDARY
import com.yonjar.clashroyalestats.utils.RarityColor.RARE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardDetailActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCardDetailBinding

    private val args:CardDetailActivityArgs by navArgs()

    private var parseColor:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(args.cardImage.isNotBlank()){
            Glide.with(this).load(args.cardImage).into(binding.ivCard)
            binding.tvName.text = getString(R.string.strCardName, args.cardName)
            binding.tvLevel.text = getString(R.string.strCardLevel, args.cardLevel)
            binding.tvElixir.text = getString(R.string.strCardElixir, args.elixirCost)

            when(args.cardRarity.uppercase()){
                COMMON.name -> {
                    parseColor = Color.parseColor(COMMON.hexColor)
                    binding.tvRarity.setTextColor(parseColor)

                }
                RARE.name -> {
                    parseColor = Color.parseColor(RARE.hexColor)
                    binding.tvRarity.setTextColor(parseColor)

                }
                EPIC.name -> {
                    parseColor = Color.parseColor(EPIC.hexColor)
                    binding.tvRarity.setTextColor(parseColor)

                }
                LEGENDARY.name -> {
                    parseColor = Color.parseColor(LEGENDARY.hexColor)
                    binding.tvRarity.setTextColor(parseColor)

                }
            }

            binding.tvRarity.text = getString(R.string.strCardRarity, args.cardRarity.replaceFirst(args.cardRarity[0], args.cardRarity[0].uppercaseChar()))

        } else{
            Toast.makeText(this,getText(R.string.unknownError), Toast.LENGTH_SHORT).show()
        }
    }

}