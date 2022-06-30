package com.example.giphyapiapp.presentation

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.giphyapiapp.R

class GifViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    val gifContainer: ImageView = view.findViewById(R.id.gifImageView)
}