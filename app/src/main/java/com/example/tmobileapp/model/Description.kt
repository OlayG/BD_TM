package com.example.tmobileapp.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Description(val attributes: Attributes?, val value: String?)