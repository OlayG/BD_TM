package com.example.tmobileapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.tmobileapp.model.Page
import com.example.tmobileapp.repo.PageRepo
import com.example.tmobileapp.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class PageFragmentViewModel @Inject constructor(repo: PageRepo) : ViewModel() {

    val page: LiveData<ApiState<Page>> = repo.getPage().asLiveData(Dispatchers.Main)

}