package com.tracking.clients.rewards

import com.tracking.clients.common.ApiResult
import com.tracking.clients.rewards.model.RewardsItem

interface RewardsClient {
    suspend fun getRewards(): ApiResult<List<RewardsItem>>
}
