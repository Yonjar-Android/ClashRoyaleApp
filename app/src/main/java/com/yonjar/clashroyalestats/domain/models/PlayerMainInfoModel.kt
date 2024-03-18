package com.yonjar.clashroyalestats.domain.models


import com.yonjar.clashroyalestats.data.modelResponses.Badges
import com.yonjar.clashroyalestats.data.modelResponses.Card

data class PlayerMainInfoModel(
    val tagPlayer: String,
    val userName: String,
    val level: Int,
    val wins:Int,
    val losses: Int,
    val currentTrophies: Int,
    val bestTrophies: Int,
    val favouriteCard: String,
    val currentDeck: List<Card>,
    val cards:List<Card>,
    val badges:List<Badges>
)