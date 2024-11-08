package com.tracking.displayrewards.data

import kotlinx.coroutines.flow.Flow

interface LocalUserManger {

    suspend fun saveSearchQuery(query: String)

    fun readSearchQuery(): Flow<String>

}