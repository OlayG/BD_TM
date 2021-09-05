package com.example.tmobileapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Page(val cards: List<CardContainer> = listOf())
