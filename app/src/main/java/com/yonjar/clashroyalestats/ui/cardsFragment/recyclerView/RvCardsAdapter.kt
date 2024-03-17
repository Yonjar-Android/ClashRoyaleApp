package com.yonjar.clashroyalestats.ui.cardsFragment.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.data.modelResponses.Card
import com.yonjar.clashroyalestats.ui.mainInfoFragment.recyclerView.MainInfoDiffUtil

class RvCardsAdapter(private val context: Context, private var cards:List<Card> ):RecyclerView.Adapter<CardsFragmentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsFragmentViewHolder {
        return CardsFragmentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.carddetail_itemview, parent, false))
    }

    override fun getItemCount(): Int = cards.size

    override fun onBindViewHolder(holder: CardsFragmentViewHolder, position: Int) {
        holder.render(context, cards[position])
    }

    fun updateList(newList:List<Card>){
        val cardsDiffUtil = MainInfoDiffUtil(cards,newList)
        val result = DiffUtil.calculateDiff(cardsDiffUtil)
        cards = newList
        result.dispatchUpdatesTo(this)
    }
}