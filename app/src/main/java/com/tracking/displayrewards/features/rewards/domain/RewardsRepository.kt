package com.tracking.displayrewards.features.rewards.domain

import com.tracking.clients.common.ApiResult
import com.tracking.displayrewards.features.rewards.domain.model.Reward

interface RewardsRepository {
    suspend fun fetchRewards(): ApiResult<Map<Int, List<Reward>>>
}