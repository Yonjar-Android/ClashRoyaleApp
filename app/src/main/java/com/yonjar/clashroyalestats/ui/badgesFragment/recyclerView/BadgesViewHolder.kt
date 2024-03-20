package com.yonjar.clashroyalestats.ui.badgesFragment.recyclerView

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.yonjar.clashroyalestats.data.modelResponses.Badges
import com.yonjar.clashroyalestats.databinding.CardItemviewBinding
import com.yonjar.clashroyalestats.domain.models.BadgeModel

class BadgesViewHolder(itemView: View):ViewHolder(itemView) {

    val binding = CardItemviewBinding.bind(itemView)

    fun render(context: Context, badge: BadgeModel){

        Glide.with(context).load(badge.image).into(binding.ivCard)

    }

}