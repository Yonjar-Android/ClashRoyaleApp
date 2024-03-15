package com.yonjar.clashroyalestats.ui.startFragment

sealed class StartFragmentState {
    data object Loading : StartFragmentState()

    data class Error(val error: String) : StartFragmentState()

    data class Success(val playerTag:String): StartFragmentState()

}