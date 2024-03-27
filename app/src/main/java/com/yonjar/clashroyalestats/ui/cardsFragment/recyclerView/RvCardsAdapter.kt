package com.yonjar.clashroyalestats.ui.cardsFragment.recyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yonjar.clashroyalestats.R
import com.yonjar.clashroyalestats.domain.models.CardModel

class RvCardsAdapter(private val context: Context, private var cards:List<CardModel>, private val toDetail: (String,String,String,Int,Int) -> Unit )
    :RecyclerView.Adapter<CardsFragmentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsFragmentViewHolder {
        return CardsFragmentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.carddetail_itemview, parent, false))
    }

    override fun getItemCount(): Int = cards.size

    override fun onBindViewHolder(holder: CardsFragmentViewHolder, position: Int) {
        holder.render(context, cards[position], toDetail)
    }

    fun updateList(newList:List<CardModel>){
        val cardsDiffUtil = CardsDiffUtil(cards,newList)
        val result = DiffUtil.calculateDiff(cardsDiffUtil)
        cards = newList
        result.dispatchUpdatesTo(this)
    }
}