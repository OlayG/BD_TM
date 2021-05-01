package com.example.tmobileapp.util

import android.graphics.Color
import com.example.tmobileapp.model.Attributes
import com.google.android.material.textview.MaterialTextView

fun MaterialTextView.setTextColor(color: String) = this.setTextColor(Color.parseColor(color))

fun MaterialTextView.setAttributes(attributes: Attributes) {
    attributes.run{
        font?.size?.toFloat()?.let {
            textSize = it
        }
        textColor?.let {
            setTextColor(it)
        }
    }
}