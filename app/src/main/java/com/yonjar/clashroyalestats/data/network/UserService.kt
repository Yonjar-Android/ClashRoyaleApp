package com.yonjar.clashroyalestats.data.network

import com.yonjar.clashroyalestats.data.modelResponses.ChestResponse
import com.yonjar.clashroyalestats.data.modelResponses.PlayerResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("players/{tag}")
    suspend fun getPlayers(@Path("tag") tag: String): PlayerResponse

    @GET("players/{tag}/upcomingchests")
    suspend fun getChestCycle(@Path("tag") tag:String): ChestResponse
}