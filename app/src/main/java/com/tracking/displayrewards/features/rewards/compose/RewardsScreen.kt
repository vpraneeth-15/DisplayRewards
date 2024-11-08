package com.tracking.displayrewards.features.rewards.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.tracking.displayrewards.features.rewards.domain.model.Reward
import com.tracking.displayrewards.features.rewards.model.RewardsUiState
import com.tracking.displayrewards.ui.dimes.Dimens.MarginStandard
import com.tracking.displayrewards.ui.dimes.Dimens.MediumPadding1

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RewardsScreen(
    state: RewardsUiState,
) {
    if (state is RewardsUiState.UpdateUi) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            state.rewards.forEach { id, rewards ->
                stickyHeader {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {
                        Text(
                            text = "Section: $id",
                            modifier = Modifier.fillMaxWidth(),
                            style = MaterialTheme.typography.headlineLarge,
                            textAlign = TextAlign.Center,
                        )
                    }
                }
                itemsIndexed(rewards, key = { _, reward -> reward.id }) { index, reward ->
                    RewardItem(reward)
                }
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MarginStandard),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val status = when (state) {
                RewardsUiState.Loading -> "Loading..."
                RewardsUiState.Error -> "Something went wrong, try again later"
                else -> ""
            }
            Text(
                text = status,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun RewardItem(item: Reward) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = MarginStandard,
                vertical = MediumPadding1,
            )
    ) {
        Text(
            text = "Reward Name: ${item.name}",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}
