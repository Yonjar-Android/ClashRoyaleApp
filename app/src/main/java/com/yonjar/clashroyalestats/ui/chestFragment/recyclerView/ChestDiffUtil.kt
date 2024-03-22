package com.yonjar.clashroyalestats.ui.chestFragment.recyclerView

import androidx.recyclerview.widget.DiffUtil
import com.yonjar.clashroyalestats.domain.models.ChestModel

class ChestDiffUtil(private val oldList:List<ChestModel>, private val newList:List<ChestModel>):DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition].name == newList[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition] == newList[newItemPosition]

}