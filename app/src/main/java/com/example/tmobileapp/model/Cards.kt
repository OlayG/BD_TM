package com.example.tmobileapp.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cards(
    @Json(name = "card_type")
    val cardType: String?,
    @Json(name = "card")
    val card: Card?
)