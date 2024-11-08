package com.tracking.displayrewards.features.rewards

import app.cash.turbine.test
import com.tracking.clients.common.ApiResult
import com.tracking.displayrewards.features.rewards.domain.RewardsRepository
import com.tracking.displayrewards.features.rewards.domain.model.Reward
import com.tracking.displayrewards.features.rewards.model.RewardsUiState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RewardsViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private val repository: RewardsRepository = mockk()

    private lateinit var viewModel: RewardsViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        val response = mapOf<Int, List<Reward>>(1 to listOf(Reward(id = 684, listId = 1, name = "Item 684")))
        coEvery { repository.fetchRewards() } returns ApiResult.Success(response)
        viewModel = RewardsViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetch rewards updates view state`() = runTest {
        advanceUntilIdle()
        viewModel.state.test {
            val item = awaitItem()
            assertTrue(item is RewardsUiState.UpdateUi && item.rewards.isNotEmpty())
        }
    }
}
