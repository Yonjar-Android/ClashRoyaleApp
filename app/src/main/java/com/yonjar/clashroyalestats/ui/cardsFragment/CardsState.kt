package com.yonjar.clashroyalestats.ui.cardsFragment

sealed class CardsState {
    data object Loading : CardsState()

    data class Error(val error: String) : CardsState()

    data class Success(val phrase:String): CardsState()
}