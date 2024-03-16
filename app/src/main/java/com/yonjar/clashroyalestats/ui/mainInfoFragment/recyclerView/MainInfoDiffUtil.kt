package com.yonjar.clashroyalestats.ui.mainInfoFragment.recyclerView

import androidx.recyclerview.widget.DiffUtil
import com.yonjar.clashroyalestats.data.modelResponses.Card

class MainInfoDiffUtil(private val oldList:List<Card>,
                       private val newList: List<Card>):DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return newList[newItemPosition].name ==  oldList[oldItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return newList[newItemPosition] == oldList[oldItemPosition]
    }

}