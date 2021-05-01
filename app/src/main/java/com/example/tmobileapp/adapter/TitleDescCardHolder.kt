package com.example.tmobileapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.tmobileapp.databinding.TextItemBinding
import com.example.tmobileapp.databinding.TitleDescItemBinding
import com.example.tmobileapp.model.Card
import com.example.tmobileapp.util.setAttributes
import com.example.tmobileapp.util.setTextColor

class TitleDescCardHolder (
    private val binding: TitleDescItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun setCard(card: Card) = with(binding) {
        tvTitle.apply {
            text = card.title?.value
            card.title?.attributes?.let { setAttributes(it) }
        }
        tvDescription.apply {
            text = card.description?.value
            card.description?.attributes?.let { setAttributes(it) }
        }
    }
}