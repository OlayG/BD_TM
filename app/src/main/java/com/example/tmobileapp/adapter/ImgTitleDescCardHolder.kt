package com.example.tmobileapp.adapter

import android.view.ViewGroup
import com.example.tmobileapp.adapter.base.CardViewHolder
import com.example.tmobileapp.databinding.ImgTitleDescItemBinding
import com.example.tmobileapp.model.Card
import com.example.tmobileapp.util.inflater
import com.example.tmobileapp.util.loadDescription
import com.example.tmobileapp.util.loadImage
import com.example.tmobileapp.util.loadTitle

class ImgTitleDescCardHolder(
    private val binding: ImgTitleDescItemBinding
) : CardViewHolder(binding) {

    override fun bindData(card: Card): Unit = with(binding) {
        ivBackground.loadImage(card.image)
        titleDescContainer.tvTitle.loadTitle(card.title)
        titleDescContainer.tvDescription.loadDescription(card.description)
        return@with
    }

    companion object {
        fun newInstance(parent: ViewGroup) = ImgTitleDescCardHolder(
            ImgTitleDescItemBinding.inflate(parent.inflater, parent, false)
        )
    }
}