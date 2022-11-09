package com.example.youtube.di

import com.example.youtube.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun providesVideoApiServices(retrofitClient: RetrofitClient) =
        retrofitClient.provideVideoApiServices()
}