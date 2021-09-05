package com.example.tmobileapp.adapter

import android.view.ViewGroup
import com.example.tmobileapp.adapter.base.CardViewHolder
import com.example.tmobileapp.databinding.TextItemBinding
import com.example.tmobileapp.model.Card
import com.example.tmobileapp.util.inflater
import com.example.tmobileapp.util.loadValue

class TextCardHolder(
    private val binding: TextItemBinding
) : CardViewHolder(binding) {

    override fun bindData(card: Card): Unit = with(binding) { tvValue.loadValue(card) }

    companion object {
        fun newInstance(parent: ViewGroup) = TextCardHolder(
            TextItemBinding.inflate(parent.inflater, parent, false)
        )
    }
}