package com.example.tmobileapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmobileapp.databinding.ImgTitleDescItemBinding
import com.example.tmobileapp.databinding.TextItemBinding
import com.example.tmobileapp.databinding.TitleDescItemBinding
import com.example.tmobileapp.model.Card
import com.example.tmobileapp.model.Cards

class CardsAdapter (
    private val cards: List<Cards>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TEXT_CARD = "text"
        const val TITLE_DESCRIPTION_CARD = "title_description"
        const val IMG_TITLE_DESCRIPTION_CARD = "image_title_description"

        const val VIEW_TYPE_TEXT_CARD = 0
        const val VIEW_TYPE_TITLE_DESCRIPTION_CARD = 1
        const val VIEW_TYPE_IMG_TITLE_DESCRIPTION_CARD = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            VIEW_TYPE_TEXT_CARD -> TextCardHolder(TextItemBinding.inflate(
                LayoutInflater.from(parent.context), parent,false))
            VIEW_TYPE_TITLE_DESCRIPTION_CARD -> TitleDescCardHolder(TitleDescItemBinding.inflate(
                LayoutInflater.from(parent.context), parent,false))
            VIEW_TYPE_IMG_TITLE_DESCRIPTION_CARD -> ImgTitleDescCardHolder(ImgTitleDescItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
            else -> ImgTitleDescCardHolder(ImgTitleDescItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            VIEW_TYPE_TEXT_CARD -> {
                val textCardHolder = holder as TextCardHolder
                cards[position].card?.let{ textCardHolder.setCard(it) }
            }
            VIEW_TYPE_TITLE_DESCRIPTION_CARD -> {
                val titleDescCardHolder = holder as TitleDescCardHolder
                cards[position].card?.let{ titleDescCardHolder.setCard(it) }
            }
            VIEW_TYPE_IMG_TITLE_DESCRIPTION_CARD -> {
                val imgTitleDescCardHolder = holder as ImgTitleDescCardHolder
                cards[position].card?.let { imgTitleDescCardHolder.setCard(it) }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(cards[position].cardType) {
            TEXT_CARD -> VIEW_TYPE_TEXT_CARD
            TITLE_DESCRIPTION_CARD -> VIEW_TYPE_TITLE_DESCRIPTION_CARD
            IMG_TITLE_DESCRIPTION_CARD -> VIEW_TYPE_IMG_TITLE_DESCRIPTION_CARD
            else -> -1
        }
    }

    override fun getItemCount() = cards.size
}