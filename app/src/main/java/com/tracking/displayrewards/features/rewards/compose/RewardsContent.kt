package com.tracking.displayrewards.features.rewards.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.tracking.displayrewards.features.rewards.RewardsViewModel

@Composable
fun RewardsContent(
    viewModel: RewardsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    RewardsScreen(
        state = state
    )
}