package com.example.tmobileapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmobileapp.R
import com.example.tmobileapp.adapter.CardsAdapter
import com.example.tmobileapp.databinding.FragmentPageBinding
import com.example.tmobileapp.viewmodel.PageFragmentViewModel

class PageFragment : Fragment(R.layout.fragment_page) {
    private val viewModel by viewModels<PageFragmentViewModel>()
    private lateinit var binding: FragmentPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentPageBinding.inflate(inflater, container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPage()
        viewModel.page.observe(this.viewLifecycleOwner, Observer { page ->
            binding.rvCard.adapter = page.cards?.let { it -> CardsAdapter(it) }
            binding.rvCard.layoutManager = LinearLayoutManager(this.context)
        })
    }
}