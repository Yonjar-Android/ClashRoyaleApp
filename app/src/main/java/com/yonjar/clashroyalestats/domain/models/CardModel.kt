package com.yonjar.clashroyalestats.domain.models

data class CardModel(
    val name:String,
    val level: Int,
    val elixirCost:Int,
    val cardImage:String,
    val rarity:String
)