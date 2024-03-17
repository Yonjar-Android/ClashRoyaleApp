package com.yonjar.clashroyalestats.ui.cardsFragment.recyclerView

import androidx.recyclerview.widget.DiffUtil
import com.yonjar.clashroyalestats.data.modelResponses.Card

class CardsDiffUtil(private val oldList:List<Card>, private val newList:List<Card>):DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition].name == newList[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition] == newList[newItemPosition]
}