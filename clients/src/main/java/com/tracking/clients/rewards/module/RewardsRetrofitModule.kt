package com.tracking.clients.rewards.module

import com.tracking.clients.rewards.RewardsClient
import com.tracking.clients.rewards.RewardsClientImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RewardsRetrofitModule {
    @Binds
    @Singleton
    abstract fun bindRewardsClient(clientImpl: RewardsClientImpl): RewardsClient
}