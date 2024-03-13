package com.yonjar.clashroyalestats.ui.badgesFragment

sealed class BadgesState {
    data object Loading : BadgesState()

    data class Error(val error: String) : BadgesState()

    data class Success(val phrase:String): BadgesState()
}
