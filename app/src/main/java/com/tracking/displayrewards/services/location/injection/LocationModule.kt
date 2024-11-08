package com.tracking.displayrewards.services.location.injection

import com.tracking.displayrewards.services.location.LocationManager
import com.tracking.displayrewards.services.location.LocationManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {
    @Binds
    @Singleton
    abstract fun bindLocationPermissionManager(impl: LocationManagerImpl): LocationManager
}