package com.yonjar.clashroyalestats.ui.chestFragment.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.domain.models.ChestModel

class RvChestAdapter(private val context: Context, private var chestList: List<ChestModel>):RecyclerView.Adapter<ChestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChestViewHolder =
        ChestViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.carddetail_itemview, parent, false))

    override fun getItemCount(): Int = chestList.size

    override fun onBindViewHolder(holder: ChestViewHolder, position: Int) {
        holder.render(context, chestList[position])
    }

    fun updateList(newList:List<ChestModel>){
        val cardsDiffUtil = ChestDiffUtil(chestList,newList)
        val result = DiffUtil.calculateDiff(cardsDiffUtil)
        chestList = newList
        result.dispatchUpdatesTo(this)
    }
}