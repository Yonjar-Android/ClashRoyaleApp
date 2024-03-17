package com.yonjar.clashroyalestats.ui.cardsFragment

import com.yonjar.clashroyalestats.data.modelResponses.Card

sealed class CardsState {
    data object Loading : CardsState()

    data class Error(val error: String) : CardsState()

    data class Success(val playerCards:List<Card>): CardsState()
}