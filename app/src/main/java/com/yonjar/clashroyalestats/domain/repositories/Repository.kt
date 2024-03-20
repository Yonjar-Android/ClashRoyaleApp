package com.yonjar.clashroyalestats.domain.repositories

import com.yonjar.clashroyalestats.domain.models.BadgeModel
import com.yonjar.clashroyalestats.domain.models.CardModel
import com.yonjar.clashroyalestats.domain.models.PlayerMainInfoModel

interface Repository {

    suspend fun getPlayerInfo(tagPlayer:String):PlayerMainInfoModel?

    suspend fun getPlayerCards(tagPlayer:String):List<CardModel>?

    suspend fun getPlayerBadges(tagPlayer:String):List<BadgeModel>?

}