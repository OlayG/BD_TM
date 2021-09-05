package com.example.tmobileapp.module

import com.example.tmobileapp.model.adapter.CardTypeAdapter
import com.example.tmobileapp.repo.remote.TMobileService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://private-8ce77c-tmobiletest.apiary-mock.com"

    @Provides
    @Singleton
    fun provideMoshiParser(): Moshi = Moshi.Builder().add(CardTypeAdapter).build()

    @Provides
    @Singleton
    fun provideTMobileService(moshi: Moshi): TMobileService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(TMobileService::class.java)

}