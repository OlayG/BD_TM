package com.example.tmobileapp.repo.remote

import com.example.tmobileapp.model.PageResponse
import retrofit2.http.GET

interface PageService {
    @GET("home")
    suspend fun getPage() : PageResponse
}