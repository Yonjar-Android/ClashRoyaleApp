package com.yonjar.clashroyalestats.ui.badgesDetailActivity

sealed class BadgesDetailState {
    data object Loading : BadgesDetailState()

    data class Error(val error: String) : BadgesDetailState()

    data class Success(val phrase:String): BadgesDetailState()
}
