package com.yonjar.clashroyalestats.domain.models


import com.yonjar.clashroyalestats.data.modelResponses.Card

data class PlayerMainInfoModel(
    val tagPlayer: String,
    val userName: String,
    val level: Int,
    val losses: Int,
    val trophies: Int,
    val bestTrophies: Int,
    val favouriteCard: String,
    val currentDeck: List<Card>
)