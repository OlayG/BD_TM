package com.example.tmobileapp.model.adapter

import com.example.tmobileapp.util.CardType
import com.squareup.moshi.JsonDataException

import com.squareup.moshi.FromJson

import com.squareup.moshi.ToJson


object CardTypeAdapter {
    @ToJson
    fun toJson(card: CardType) = card.name

    @FromJson
    fun fromJson(cardType: String) = when (cardType) {
        "text" -> CardType.TEXT
        "title_description" -> CardType.TITLE_DESCRIPTION
        "image_title_description" -> CardType.IMAGE_TITLE_DESCRIPTION
        else -> throw JsonDataException("unknown cardType: $cardType")
    }
}