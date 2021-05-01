package com.example.tmobileapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmobileapp.databinding.ImgTitleDescItemBinding
import com.example.tmobileapp.model.Card
import com.example.tmobileapp.util.setAttributes
import com.example.tmobileapp.util.setTextColor

class ImgTitleDescCardHolder (
    private val binding: ImgTitleDescItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun setCard(card: Card) = with(binding) {
        Glide.with(root.context).load(card.image?.url).into(ivBackground)
        ivBackground.layoutParams.apply {
            card.image?.size?.width?.let {
                width = it
            }
            card.image?.size?.height?.let {
                height = it
            }
        }
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