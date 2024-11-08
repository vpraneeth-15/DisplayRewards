package com.tracking.clients.rewards.module

import com.tracking.clients.rewards.RewardsApi
import com.tracking.clients.rewards.utils.Constants.REWARDS_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RewardsClientModule {

    @Provides
    @Singleton
    fun provideApiInstance(): RewardsApi {
        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        return Retrofit
            .Builder()
            .baseUrl(REWARDS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
            .build()
            .create(RewardsApi::class.java)
    }
}
