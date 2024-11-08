package com.tracking.displayrewards.data.injection.module

import com.tracking.displayrewards.data.LocalUserManger
import com.tracking.displayrewards.data.LocalUserManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalMangerModule {

    @Binds
    @Singleton
    abstract fun bindLocalUserManger(localUserMangerImpl: LocalUserManagerImpl) : LocalUserManger
}