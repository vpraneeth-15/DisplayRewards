package com.tracking.displayrewards.features.rewards.domain

import com.tracking.clients.common.ApiResult
import com.tracking.clients.rewards.RewardsClient
import com.tracking.displayrewards.features.rewards.domain.mapper.RewardsMapper
import com.tracking.displayrewards.features.rewards.domain.model.Reward
import javax.inject.Inject

class RewardsUseCase @Inject constructor(
    private val client: RewardsClient,
    private val mapper: RewardsMapper,
) : RewardsRepository {
    override suspend fun fetchRewards(): ApiResult<Map<Int, List<Reward>>> {
        val result = client.getRewards()
        return when (result) {
            is ApiResult.Success -> {
                ApiResult.Success(
                    response = mapper.from(result.response)
                )
            }
            is ApiResult.Error -> ApiResult.Error(result.message)
        }
    }
}
