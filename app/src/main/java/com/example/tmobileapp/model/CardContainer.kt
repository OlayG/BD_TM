package com.example.tmobileapp.model

import com.example.tmobileapp.util.CardType
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CardContainer(@Json(name = "card_type") val cardType: CardType, val card: Card)