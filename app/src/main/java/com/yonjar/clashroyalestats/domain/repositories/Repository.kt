package com.yonjar.clashroyalestats.domain.repositories

import com.yonjar.clashroyalestats.domain.models.PlayerMainInfoModel

interface Repository {

    suspend fun getPlayerInfo(tagPlayer:String):PlayerMainInfoModel?

}