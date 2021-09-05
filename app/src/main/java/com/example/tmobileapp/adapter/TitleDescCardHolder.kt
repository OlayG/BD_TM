package com.example.tmobileapp.adapter

import android.view.ViewGroup
import com.example.tmobileapp.adapter.base.CardViewHolder
import com.example.tmobileapp.databinding.TitleDescItemBinding
import com.example.tmobileapp.model.Card
import com.example.tmobileapp.util.inflater
import com.example.tmobileapp.util.loadDescription
import com.example.tmobileapp.util.loadTitle

class TitleDescCardHolder(
    private val binding: TitleDescItemBinding
) : CardViewHolder(binding) {

    override fun bindData(card: Card): Unit = with(binding) {
        tvTitle.loadTitle(card.title)
        tvDescription.loadDescription(card.description)
        return@with
    }

    companion object {
        fun newInstance(parent: ViewGroup) = TitleDescCardHolder(
            TitleDescItemBinding.inflate(parent.inflater, parent, false)
        )
    }
}