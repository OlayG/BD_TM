package com.example.tmobileapp.repo

import android.util.Log
import com.example.tmobileapp.model.Page
import com.example.tmobileapp.repo.remote.RetrofitInstance
import retrofit2.HttpException

object PageRepo {

    suspend fun getPage() : Page? {
        try {
            return RetrofitInstance.pageService.getPage().page
        } catch(ex: HttpException) {
            Log.e("PageRepo", ex.message())
        }
        return null
    }
}