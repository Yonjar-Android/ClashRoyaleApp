package com.yonjar.clashroyalestats.ui.chestFragment

sealed class ChestState {
    data object Loading : ChestState()

    data class Error(val error: String) : ChestState()

    data class Success(val phrase:String): ChestState()
}