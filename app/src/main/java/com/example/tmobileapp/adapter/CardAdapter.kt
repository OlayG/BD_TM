package com.example.tmobileapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.tmobileapp.adapter.base.CardViewHolder
import com.example.tmobileapp.adapter.util.CardDiffUtil
import com.example.tmobileapp.model.CardContainer
import com.example.tmobileapp.util.CardType

class CardAdapter : ListAdapter<CardContainer, CardViewHolder>(CardDiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ) = when (viewType) {
        CardType.TEXT.ordinal -> TextCardHolder.newInstance(parent)
        CardType.TITLE_DESCRIPTION.ordinal -> TitleDescCardHolder.newInstance(parent)
        CardType.IMAGE_TITLE_DESCRIPTION.ordinal -> ImgTitleDescCardHolder.newInstance(parent)
        else -> throw IllegalArgumentException("Invalid view type")
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindData(getItem(position).card)
    }

    override fun getItemViewType(position: Int) = getItem(position).cardType.ordinal
}