package com.yonjar.clashroyalestats.ui.chestFragment.recyclerView

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.yonjar.clashroyalestats.databinding.CarddetailItemviewBinding
import com.yonjar.clashroyalestats.domain.models.ChestModel
import com.yonjar.clashroyalestats.utils.DesignUtils

class ChestViewHolder(itemView: View) : ViewHolder(itemView) {

    val binding = CarddetailItemviewBinding.bind(itemView)
    @SuppressLint("SetTextI18n")
    fun render(context: Context, chest: ChestModel) {

        Glide.with(context).load(DesignUtils.getChestImage(chest.name)).into(binding.ivCard)

        binding.tvCardName.text = "+${chest.index}"
    }

}