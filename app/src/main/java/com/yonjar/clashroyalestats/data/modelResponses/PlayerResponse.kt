package com.yonjar.clashroyalestats.data.modelResponses

import com.google.gson.annotations.SerializedName
import com.yonjar.clashroyalestats.domain.models.BadgeModel
import com.yonjar.clashroyalestats.domain.models.CardModel
import com.yonjar.clashroyalestats.domain.models.PlayerMainInfoModel

data class PlayerResponse(
    @SerializedName("tag") val tagPlayer: String,
    @SerializedName("name") val userName: String,
    @SerializedName("expLevel") val level: Int,
    @SerializedName("wins") val wins: Int,
    @SerializedName("losses") val losses: Int,
    @SerializedName("trophies") val trophies: Int,
    @SerializedName("bestTrophies") val bestTrophies: Int,
    @SerializedName("badges") val badges: List<Badges>,
    @SerializedName("cards") val cards: List<Card>,
    @SerializedName("currentFavouriteCard") val favouriteCard: Card,
    @SerializedName("currentDeck") val currentDeck: List<Card>
) {
    fun toPlayerModel() = PlayerMainInfoModel(
        tagPlayer = tagPlayer,
        userName = userName,
        level = level,
        wins = wins,
        losses = losses,
        currentTrophies = trophies,
        bestTrophies = bestTrophies,
        favouriteCard = favouriteCard.cardImage.medium,
        currentDeck = currentDeck.map { it.toCardModel() },
        cards = cards.map { it.toCardModel() },
        badges = badges.map { it.toBadgeModel() }
    )
}

data class Card(
    @SerializedName("name") val name: String,
    @SerializedName("level") val level: Int,
    @SerializedName("rarity") val rarity: String,
    @SerializedName("elixirCost") val elixir: Int,
    @SerializedName("iconUrls") val cardImage: IconUrlsCard
) {
    fun toCardModel() = CardModel(
        name = name,
        level = level,
        rarity = rarity,
        elixirCost = elixir,
        cardImage = cardImage.medium
    )
}

data class IconUrlsCard(
    @SerializedName("medium") val medium: String
)

data class Badges(
    @SerializedName("name") val name: String,
    @SerializedName("level") val level: Int,
    @SerializedName("iconUrls") val image: IconUrlsBadge
) {
    fun toBadgeModel() = BadgeModel(
        name = name,
        level = level,
        image = image.badgeImage
    )
}

data class IconUrlsBadge(
    @SerializedName("large") val badgeImage: String
)