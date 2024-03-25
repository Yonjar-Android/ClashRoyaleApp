package com.yonjar.clashroyalestats

import com.yonjar.clashroyalestats.data.modelResponses.Badges
import com.yonjar.clashroyalestats.data.modelResponses.Card
import com.yonjar.clashroyalestats.data.modelResponses.ChestModelResponse
import com.yonjar.clashroyalestats.data.modelResponses.ChestResponse
import com.yonjar.clashroyalestats.data.modelResponses.IconUrlsBadge
import com.yonjar.clashroyalestats.data.modelResponses.IconUrlsCard
import com.yonjar.clashroyalestats.data.modelResponses.PlayerResponse
import com.yonjar.clashroyalestats.domain.models.PlayerMainInfoModel

object MotherObject {

    private val cardsList = listOf(
        Card("hog rider", 11, "special", 4, IconUrlsCard("HogRider")),
        Card("archer", 13, "common", 3, IconUrlsCard("archer")),
        Card("knight", 14, "common", 3, IconUrlsCard("knight"))
    )

     val chestList = ChestResponse(
         listOf(
             ChestModelResponse(1, "Gold Chest"),
             ChestModelResponse(2, "gold crate",),
             ChestModelResponse(3, "Magical Chest"),
             ChestModelResponse(4, "Giant Chest"))
     )

    private val badgesList = listOf(
        Badges("YearsPlayed", 7, IconUrlsBadge("yearsPlayerImg")),
        Badges("BattleWins", 6, IconUrlsBadge("battleWinsImg"))
    )

    private val badgeListModel = badgesList.map { it.toBadgeModel() }
    private val cardListModel = cardsList.map { it.toCardModel() }

    val userResponse = PlayerResponse(
        "8YCLLVCG",
        "Yonjar",
        40,
        2000,
        1000,
        4000,
        6000,
        badgesList,
        cardsList,
        Card(
            "Hog rider", 11, "special", 4, IconUrlsCard("HogRider")
        )
        , listOf()
    )

    val userModel = PlayerMainInfoModel(
        "8YCLLVCG",
        "Yonjar",
        40,
        2000,
        1000,
        4000,
        6000,
        "HogRider",
        listOf(),
        cardListModel,
        badgeListModel
    )

}