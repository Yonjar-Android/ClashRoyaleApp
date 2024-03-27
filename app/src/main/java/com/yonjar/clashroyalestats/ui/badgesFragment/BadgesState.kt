package com.yonjar.clashroyalestats.ui.badgesFragment

import com.yonjar.clashroyalestats.domain.models.BadgeModel

sealed class BadgesState {
    data object Loading : BadgesState()

    data class Error(val error: String) : BadgesState()

    data class Success(val badges:List<BadgeModel>): BadgesState()
}
