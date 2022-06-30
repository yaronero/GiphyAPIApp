package com.example.giphyapiapp.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.giphyapiapp.R
import com.example.giphyapiapp.model.GifData

class GifAdapter(
    private val context: Context,
    private val gifList: List<GifData>
) : RecyclerView.Adapter<GifViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_gif, parent, false)
        return GifViewHolder(view)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        Glide.with(context)
            .load(gifList[position].gifUrl)
            .into(holder.gifContainer)
    }

    override fun getItemCount(): Int = gifList.size
}