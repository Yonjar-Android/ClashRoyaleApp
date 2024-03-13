package com.yonjar.clashroyalestats.ui.cardsDetailActivity

sealed class CardDetailState {
    data object Loading : CardDetailState()

    data class Error(val error: String) : CardDetailState()

    data class Success(val phrase:String): CardDetailState()
}