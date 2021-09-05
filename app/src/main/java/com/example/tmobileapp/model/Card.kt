package com.example.tmobileapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Card(
    val attributes: Attributes?,
    val description: Description?,
    val image: Image?,
    val title: Title?,
    val value: String?
)