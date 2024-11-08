package com.tracking.displayrewards.features.rewards.domain.mapper

import com.tracking.clients.rewards.model.RewardsItem
import com.tracking.displayrewards.features.rewards.domain.model.Reward
import org.junit.Assert.assertEquals
import org.junit.Test

class RewardsMapperTest {

    private val rewardsMapper = RewardsMapper()

    @Test
    fun `from should map and group rewards correctly`() {
        val rewardsItems = listOf(
            RewardsItem(1, 1, "Reward 1"),
            RewardsItem(2, 1, "Reward 2"),
            RewardsItem(3, 2, "Reward 3"),
            RewardsItem(4, 2, null),
            RewardsItem(5, 1, "Reward 5")
        )

        val expectedRewardsMap = mapOf(
            1 to listOf(
                Reward(1, 1, "Reward 1"),
                Reward(2, 1, "Reward 2"),
                Reward(5, 1, "Reward 5")
            ),
            2 to listOf(
                Reward(3, 2, "Reward 3")
            )
        )

        val actualRewardsMap = rewardsMapper.from(rewardsItems)

        assertEquals(expectedRewardsMap, actualRewardsMap)
    }

    @Test
    fun `from should handle empty list`() {
        val rewardsItems = emptyList<RewardsItem>()

        val expectedRewardsMap = emptyMap<Int, List<Reward>>()

        val actualRewardsMap = rewardsMapper.from(rewardsItems)

        assertEquals(expectedRewardsMap, actualRewardsMap)
    }

    @Test
    fun `from should handle list with all null names`() {
        val rewardsItems = listOf(
            RewardsItem(1, 1, ""),
            RewardsItem(2, 1, null),
            RewardsItem(3, 2, "   ") // This should be filtered out
        )

        val expectedRewardsMap = emptyMap<Int, List<Reward>>()

        val actualRewardsMap = rewardsMapper.from(rewardsItems)

        assertEquals(expectedRewardsMap, actualRewardsMap)
    }

}
