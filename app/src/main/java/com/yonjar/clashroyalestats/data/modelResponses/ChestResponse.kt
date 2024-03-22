package com.yonjar.clashroyalestats.data.modelResponses

import com.google.gson.annotations.SerializedName
import com.yonjar.clashroyalestats.domain.models.ChestModel

data class ChestResponse(
    @SerializedName("items") val chestList:List<ChestModelResponse>
)

data class ChestModelResponse(
    @SerializedName("index") val index:Int,
    @SerializedName("name") val name:String
){
    fun toChestModel() = ChestModel(name,index)
}

