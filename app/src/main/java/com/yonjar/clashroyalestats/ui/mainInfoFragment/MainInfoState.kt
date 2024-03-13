package com.yonjar.clashroyalestats.ui.mainInfoFragment

sealed class MainInfoState {
    data object Loading : MainInfoState()

    data class Error(val error: String) : MainInfoState()

    data class Success(val phrase:String): MainInfoState()
}