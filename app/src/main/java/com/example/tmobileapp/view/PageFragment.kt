package com.example.tmobileapp.view

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmobileapp.R
import com.example.tmobileapp.adapter.CardAdapter
import com.example.tmobileapp.databinding.FragmentPageBinding
import com.example.tmobileapp.model.Page
import com.example.tmobileapp.util.ApiState
import com.example.tmobileapp.viewmodel.PageFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PageFragment : Fragment(R.layout.fragment_page) {

    private val viewModel by viewModels<PageFragmentViewModel>()
    private val adapter by lazy { CardAdapter() }
    private lateinit var binding: FragmentPageBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPageBinding.bind(view).apply { rvCard.adapter = adapter }
        viewModel.page.observe(viewLifecycleOwner) { state ->
            binding.pbFetching.isVisible = state is ApiState.Loading
            if (state is ApiState.Success) pageSuccess(state.data)
            if (state is ApiState.Failure) pageFailure(state.errorMsg)

        }
    }

    private fun pageSuccess(page: Page) {
        adapter.submitList(page.cards)
    }

    private fun pageFailure(errorMsg: String) {

    }
}