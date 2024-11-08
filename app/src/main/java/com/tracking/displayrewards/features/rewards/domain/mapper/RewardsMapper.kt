package com.tracking.displayrewards.features.rewards.domain.mapper

import com.tracking.clients.rewards.model.RewardsItem
import com.tracking.displayrewards.features.rewards.domain.model.Reward
import javax.inject.Inject

class RewardsMapper @Inject constructor() {
    fun from(client: List<RewardsItem>): Map<Int, List<Reward>> {
        return client
            .filter { !it.name.isNullOrBlank() }
            .sortedWith(compareBy({ it.listId }, { it.name }))
            .map { Reward(it.id, it.listId, it?.name ?: "") }
            .groupBy { it.listId }
    }
}
