package com.example.tmobileapp.repo.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://private-8ce77c-tmobiletest.apiary-mock.com/test/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val pageService: PageService by lazy {
        retrofit.create(PageService::class.java)
    }
}