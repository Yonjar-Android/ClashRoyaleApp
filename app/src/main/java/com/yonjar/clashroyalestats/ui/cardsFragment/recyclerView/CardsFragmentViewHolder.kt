package com.yonjar.clashroyalestats.ui.cardsFragment.recyclerView

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.yonjar.clashroyalestats.databinding.CarddetailItemviewBinding
import com.yonjar.clashroyalestats.domain.models.CardModel

class CardsFragmentViewHolder(itemView: View) :ViewHolder(itemView) {

    private val binding = CarddetailItemviewBinding.bind(itemView)

    fun render(context: Context, card: CardModel, toDetail: (String,String,String,Int,Int) -> Unit){
        Glide.with(context).load(card.cardImage).into(binding.ivCard)

        binding.tvCardName.text = card.name

        itemView.setOnClickListener {
            toDetail(card.name, card.rarity, card.cardImage, card.level, card.elixirCost)
        }
    }

}