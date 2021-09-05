package com.example.tmobileapp.util

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.tmobileapp.model.*
import com.google.android.material.textview.MaterialTextView

val ViewGroup.inflater : LayoutInflater
    get() = LayoutInflater.from(context)

fun ImageView.loadImage(image: Image?) {
    Glide.with(context).load(image?.url).into(this)
    image?.size?.width?.let { layoutParams.width = it }
    image?.size?.height?.let { layoutParams.height = it }
}

fun MaterialTextView.loadValue(card: Card) = apply {
    text = card.value
    card.attributes?.let { setAttributes(it) }
}

fun MaterialTextView.loadTitle(title: Title?) = apply {
    text = title?.value
    title?.attributes?.let { setAttributes(it) }
}

fun MaterialTextView.loadDescription(description: Description?) = apply {
    text = description?.value
    description?.attributes?.let { setAttributes(it) }
}

private fun MaterialTextView.setAttributes(attributes: Attributes) {
    attributes.font?.size?.toFloat()?.let { textSize = it }
    attributes.textColor?.let { setTextColor(Color.parseColor(it)) }
}
