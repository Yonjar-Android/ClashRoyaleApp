package com.yonjar.clashroyalestats.utils

import com.yonjar.clashroyalestats.R

object DesignUtils {

    fun getChestImage(chestName:String):Int = when(chestName) {
        "Gold Crate" -> { R.drawable.gold_crate}
        "Plentiful Gold Crate" -> {R.drawable.plentiful_gold_crate}
        "Golden Chest" -> {R.drawable.golden_chest}
        "Tower Troop Chest" -> {R.drawable.tower_troop_chest}
        "Giant Chest" -> {R.drawable.giant_chest}
        "Magical Chest" -> {R.drawable.magic_chest}
        "Overflowing Gold Crate" -> {R.drawable.overflowing_gold_crate}
        "Royal Wild Chest" -> {R.drawable.royal_wild_chest}
        "Legendary Chest" -> {R.drawable.legendary_chest}
        "Epic Chest" -> {R.drawable.epic_chest}
        "Mega Lightning Chest" -> {R.drawable.mlc_chest}
        else -> { 0 }
    }

}