package com.yonjar.clashroyalestats.ui.mainInfoFragment.recyclerView

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.yonjar.clashroyalestats.databinding.CardItemviewBinding
import com.yonjar.clashroyalestats.domain.models.CardModel

class MainInfoViewHolder(itemView: View) : ViewHolder(itemView) {

    private val binding = CardItemviewBinding.bind(itemView)

    fun render(context: Context, card: CardModel){
        Glide.with(context).load(card.cardImage).into(binding.ivCard)
    }

}