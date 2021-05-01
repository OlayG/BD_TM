package com.example.tmobileapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.tmobileapp.databinding.TextItemBinding
import com.example.tmobileapp.model.Card
import com.example.tmobileapp.util.setAttributes
import com.example.tmobileapp.util.setTextColor

class TextCardHolder (
    private val binding: TextItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun setCard(card: Card) = with(binding) {
        tvValue.apply {
            text = card.value
            card.attributes?.let { setAttributes(it) }
        }
    }
}