package com.tracking.clients.rewards.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RewardsItem(
    val id: Int,
    val listId: Int,
    val name: String?,
)