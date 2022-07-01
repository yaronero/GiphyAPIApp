package com.example.giphyapiapp.model

import com.google.gson.annotations.SerializedName

data class DataResult(
    @SerializedName("data") val result: List<DataImage>
)
