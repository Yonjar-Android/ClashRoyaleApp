package com.yonjar.clashroyalestats.ui.cardsFragment

import com.yonjar.clashroyalestats.domain.models.CardModel

sealed class CardsState {
    data object Loading : CardsState()

    data class Error(val error: String) : CardsState()

    data class Success(val playerCards:List<CardModel>): CardsState()
}