package com.tracking.displayrewards.features.rewards.module

import com.tracking.displayrewards.features.rewards.domain.RewardsRepository
import com.tracking.displayrewards.features.rewards.domain.RewardsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RewardsModule {
    @Binds
    abstract fun bindRewardsRepository(useCase: RewardsUseCase): RewardsRepository
}
