package com.yonjar.clashroyalestats.ui.cardsFragment.recyclerView

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.yonjar.clashroyalestats.data.modelResponses.Card
import com.yonjar.clashroyalestats.databinding.CarddetailItemviewBinding

class CardsFragmentViewHolder(itemView: View) :ViewHolder(itemView) {

    private val binding = CarddetailItemviewBinding.bind(itemView)

    fun render(context: Context, card: Card){
        Glide.with(context).load(card.cardImage.medium).into(binding.ivCard)

        binding.tvCardName.text = card.name
    }

}