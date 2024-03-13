package com.yonjar.clashroyalestats.ui.mainInfoFragment

import com.yonjar.clashroyalestats.domain.models.PlayerMainInfoModel

sealed class MainInfoState {
    data object Loading : MainInfoState()

    data class Error(val error: String) : MainInfoState()

    data class Success(val playerInfo:PlayerMainInfoModel): MainInfoState()
}