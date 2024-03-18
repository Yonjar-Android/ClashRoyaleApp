package com.yonjar.clashroyalestats.data.modelResponses

import com.google.gson.annotations.SerializedName
import com.yonjar.clashroyalestats.domain.models.PlayerMainInfoModel

data class PlayerResponse(
    @SerializedName("tag") val tagPlayer:String,
    @SerializedName("name") val userName:String,
    @SerializedName("expLevel") val level:Int,
    @SerializedName("wins") val wins:Int,
    @SerializedName("losses") val losses:Int,
    @SerializedName("trophies") val trophies:Int,
    @SerializedName("bestTrophies") val bestTrophies:Int,
    @SerializedName("badges") val badges: List<Badges>,
    @SerializedName("cards") val cards:List<Card>,
    @SerializedName("currentFavouriteCard") val favouriteCard:Card,
    @SerializedName("currentDeck") val currentDeck:List<Card>
) {
    fun toPlayerModel() = PlayerMainInfoModel(
        tagPlayer = tagPlayer, userName = userName, level = level, wins = wins, losses = losses,
        currentTrophies = trophies, bestTrophies = bestTrophies, favouriteCard = favouriteCard.cardImage.medium,
        currentDeck = currentDeck, cards, badges
    )
}

data class Card(
    @SerializedName("name") val name:String,
    @SerializedName("level") val level: Int,
    @SerializedName("rarity") val rarity:String,
    @SerializedName("elixirCost") val elixir:Int,
    @SerializedName("iconUrls") val cardImage:IconUrlsCard
)

data class IconUrlsCard(
    @SerializedName("medium") val medium:String
)

data class Badges(
    @SerializedName("name") val name:String,
    @SerializedName("level") val level: Int,
    @SerializedName("iconUrls") val image:IconUrlsBadge
)

data class IconUrlsBadge(
    @SerializedName("large") val badgeImage:String
)