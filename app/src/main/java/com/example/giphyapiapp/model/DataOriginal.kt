package com.example.giphyapiapp.model

import com.google.gson.annotations.SerializedName

class DataOriginal(
    @SerializedName("original") val originalUrl: GifURL
)