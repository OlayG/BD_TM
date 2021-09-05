package com.example.tmobileapp.adapter.util

import androidx.recyclerview.widget.DiffUtil
import com.example.tmobileapp.model.CardContainer

object CardDiffUtil : DiffUtil.ItemCallback<CardContainer>() {
    override fun areItemsTheSame(
        oldItem: CardContainer, newItem: CardContainer
    ) = oldItem.cardType == newItem.cardType

    override fun areContentsTheSame(
        oldItem: CardContainer, newItem: CardContainer
    ) = oldItem == newItem
}