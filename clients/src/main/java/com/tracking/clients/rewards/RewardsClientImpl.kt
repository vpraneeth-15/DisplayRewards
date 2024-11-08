package com.tracking.clients.rewards

import com.tracking.clients.common.ApiResult
import com.tracking.clients.common.Message
import com.tracking.clients.rewards.model.RewardsItem
import javax.inject.Inject

class RewardsClientImpl @Inject constructor(private val rewardsApi: RewardsApi) : RewardsClient {
    override suspend fun getRewards(): ApiResult<List<RewardsItem>> {
        return try {
            val response = rewardsApi.getRewards()
            ApiResult.Success(response)
        } catch (e: Exception) {
            ApiResult.Error(
                message = Message(
                    code = 500,
                    message = "Something went wrong, please try again"
                )
            )
        }
    }
}
