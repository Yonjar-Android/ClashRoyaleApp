package com.yonjar.clashroyalestats.ui.mainInfoFragment.recyclerView

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.yonjar.clashroyalestats.data.modelResponses.Card
import com.yonjar.clashroyalestats.databinding.CardItemviewBinding

class MainInfoViewHolder(itemView: View) : ViewHolder(itemView) {

    private val binding = CardItemviewBinding.bind(itemView)

    fun render(context: Context, card: Card){
        Glide.with(context).load(card.cardImage.medium).into(binding.ivCard)
    }

}