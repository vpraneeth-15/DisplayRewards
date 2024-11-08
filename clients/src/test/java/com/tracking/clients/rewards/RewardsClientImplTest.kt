package com.tracking.clients.rewards

import com.tracking.clients.common.ApiResult
import com.tracking.clients.rewards.model.RewardsItem
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class RewardsClientImplTest {
    private lateinit var rewardsClient: RewardsClient

    private val rewardsApi = mockk<RewardsApi>()

    @Before
    fun setup() {
        rewardsClient = RewardsClientImpl(rewardsApi)
    }

    @Test
    fun `getRewards returns Success with response`() = runBlocking {
        val response = mockk<List<RewardsItem>>()
        coEvery { rewardsApi.getRewards() } returns response

        val result = rewardsClient.getRewards()

        assertTrue(result is ApiResult.Success)
        assertEquals(response, (result as ApiResult.Success).response)
    }

    @Test
    fun `getRewards returns Error with exception`() = runBlocking {
        val exception = Exception("Test exception")
        coEvery { rewardsApi.getRewards() } throws exception

        val result = rewardsClient.getRewards()

        assertTrue(result is ApiResult.Error)
        assertTrue((result as ApiResult.Error).message.code >= 0)
    }
}
