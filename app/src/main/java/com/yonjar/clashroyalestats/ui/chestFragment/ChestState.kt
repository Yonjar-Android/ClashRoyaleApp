package com.yonjar.clashroyalestats.ui.chestFragment

import com.yonjar.clashroyalestats.domain.models.ChestModel

sealed class ChestState {
    data object Loading : ChestState()

    data class Error(val error: String) : ChestState()

    data class Success(val chestList:List<ChestModel>): ChestState()
}