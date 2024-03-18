package com.yonjar.clashroyalestats.ui.badgesFragment

import com.yonjar.clashroyalestats.data.modelResponses.Badges
import com.yonjar.clashroyalestats.domain.models.PlayerMainInfoModel

sealed class BadgesState {
    data object Loading : BadgesState()

    data class Error(val error: String) : BadgesState()

    data class Success(val badges:List<Badges>): BadgesState()
}
