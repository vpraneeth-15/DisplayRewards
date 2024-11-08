package com.tracking.displayrewards.features.rewards.model

import com.tracking.clients.rewards.model.RewardsItem
import com.tracking.displayrewards.features.rewards.domain.model.Reward

sealed class RewardsUiState {
    object Loading : RewardsUiState()
    object Error : RewardsUiState()
    data class UpdateUi(val rewards: Map<Int, List<Reward>>) : RewardsUiState()
    object Empty : RewardsUiState()
}

