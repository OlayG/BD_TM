package com.example.tmobileapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmobileapp.model.Page
import com.example.tmobileapp.repo.PageRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PageFragmentViewModel : ViewModel() {
    private val _page = MutableLiveData<Page>()
    val page: LiveData<Page> get() = _page

    fun getPage() {
        viewModelScope.launch(Dispatchers.IO) {
            val page = PageRepo.getPage()
            page?.let {
                _page.postValue(it)
            }
        }
    }
}