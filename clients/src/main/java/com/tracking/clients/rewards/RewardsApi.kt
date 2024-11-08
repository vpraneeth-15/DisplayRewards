package com.tracking.clients.rewards

import com.tracking.clients.rewards.model.RewardsItem
import retrofit2.http.GET

interface RewardsApi {
    @GET("hiring.json")
    suspend fun getRewards() : List<RewardsItem>
}
