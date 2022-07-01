package com.example.giphyapiapp.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.giphyapiapp.R

class GifAdapter(
    private val context: Context,
    private var gifList: List<String>
) : RecyclerView.Adapter<GifViewHolder>() {

    fun setList(list: List<String>){
        gifList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_gif, parent, false)
        return GifViewHolder(view)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        Glide.with(context)
            .load(gifList[position])
            .into(holder.gifContainer)
    }

    override fun getItemCount(): Int = gifList.size
}