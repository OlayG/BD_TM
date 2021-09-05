package com.example.tmobileapp.adapter.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.tmobileapp.model.Card

abstract class CardViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    abstract fun bindData(card: Card)

}
