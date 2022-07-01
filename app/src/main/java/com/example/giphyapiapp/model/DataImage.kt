package com.example.giphyapiapp.model

import com.google.gson.annotations.SerializedName

data class DataImage(
    @SerializedName("images") val image: DataOriginal
)