package com.yonjar.clashroyalestats.ui.mainInfoFragment.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.data.modelResponses.Card

class RvMainInfoAdapter(private val context: Context, private var cardList: List<Card>):RecyclerView.Adapter<MainInfoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainInfoViewHolder {
        return MainInfoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_itemview,parent, false))
    }

    override fun getItemCount(): Int = cardList.size

    override fun onBindViewHolder(holder: MainInfoViewHolder, position: Int) {
       holder.render(context, cardList[position])
    }

    fun updateList(newList:List<Card>){
        val cardsDiffUtil = MainInfoDiffUtil(cardList,newList)
        val result = DiffUtil.calculateDiff(cardsDiffUtil)
        cardList = newList
        result.dispatchUpdatesTo(this)
    }
}