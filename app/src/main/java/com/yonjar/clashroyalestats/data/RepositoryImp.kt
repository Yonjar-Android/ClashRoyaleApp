package com.yonjar.clashroyalestats.data

import android.util.Log
import com.yonjar.clashroyalestats.data.network.UserService
import com.yonjar.clashroyalestats.domain.models.BadgeModel
import com.yonjar.clashroyalestats.domain.models.CardModel
import com.yonjar.clashroyalestats.domain.models.ChestModel
import com.yonjar.clashroyalestats.domain.models.PlayerMainInfoModel
import com.yonjar.clashroyalestats.domain.repositories.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val service: UserService):Repository {
    override suspend fun getPlayerInfo(tagPlayer: String): PlayerMainInfoModel? {
        runCatching {
            service.getPlayers(tagPlayer)
        }. onFailure { println("${it.message}")  }
            .onSuccess { return it.toPlayerModel() }

        return null
    }

    override suspend fun getPlayerCards(tagPlayer: String): List<CardModel>? {
        runCatching {
            service.getPlayers(tagPlayer)
        }. onFailure { println("${it.message}")  }
            .onSuccess {  return it.toPlayerModel().cards }

        return null
    }

    override suspend fun getPlayerBadges(tagPlayer: String): List<BadgeModel>? {
        runCatching {
            service.getPlayers(tagPlayer)
        }. onFailure { println("${it.message}") }
            .onSuccess { return it.toPlayerModel().badges}

        return null
    }

    override suspend fun getChestCycle(tagPlayer: String): List<ChestModel>? {
        runCatching {
            service.getChestCycle(tagPlayer)
        }. onFailure { println("${it.message}") }
            .onSuccess { it -> return it.chestList.map { it.toChestModel() } }

        return null
    }

}