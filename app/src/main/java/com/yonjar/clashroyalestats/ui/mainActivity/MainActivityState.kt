package com.yonjar.clashroyalestats.ui.mainActivity

sealed class MainActivityState {
    data object Loading : MainActivityState()

    data class Error(val error: String) : MainActivityState()

    data class Success(val phrase:String): MainActivityState()
}