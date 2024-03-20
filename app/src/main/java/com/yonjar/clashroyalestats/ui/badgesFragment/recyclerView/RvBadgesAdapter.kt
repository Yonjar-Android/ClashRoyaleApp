package com.yonjar.clashroyalestats.ui.badgesFragment.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.data.modelResponses.Badges
import com.yonjar.clashroyalestats.domain.models.BadgeModel

class RvBadgesAdapter(private val context: Context, private var badgesList: List<BadgeModel>):RecyclerView.Adapter<BadgesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BadgesViewHolder =
        BadgesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_itemview, parent, false))

    override fun getItemCount(): Int = badgesList.size

    override fun onBindViewHolder(holder: BadgesViewHolder, position: Int) {
        holder.render(context,badgesList[position])
    }

    fun updateList(newList:List<BadgeModel>){
        val cardsDiffUtil = BadgesDiffUtil(badgesList,newList)
        val result = DiffUtil.calculateDiff(cardsDiffUtil)
        badgesList = newList
        result.dispatchUpdatesTo(this)
    }
}