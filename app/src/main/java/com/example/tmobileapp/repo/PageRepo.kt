package com.example.tmobileapp.repo

import com.example.tmobileapp.repo.remote.TMobileService
import com.example.tmobileapp.util.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PageRepo @Inject constructor(private val tMobileService: TMobileService) {

    fun getPage() = flow {
        emit(ApiState.Loading)
        val response = tMobileService.getTMobileResponse()
        val state = if (response.isSuccessful) {
            response.body()?.let {
                ApiState.Success(it.page)
            } ?: ApiState.Failure("No data found.")

        } else ApiState.Failure("Error fetching page")
        emit(state)
    }.flowOn(Dispatchers.IO)
}