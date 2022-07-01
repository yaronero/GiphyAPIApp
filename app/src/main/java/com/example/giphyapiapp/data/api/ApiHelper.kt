package com.example.giphyapiapp.data.api

import com.example.giphyapiapp.model.DataResult
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiHelper {

    @GET("v1/gifs/trending?api_key=$API_KEY&limit=$LIMIT&rating=g")
    suspend fun getAllGifs(): Response<DataResult>

    companion object{
        private const val API_KEY = "nXEaLef6vZx7CHAiZTTy2gWkqOPe4rUO"
        private const val LIMIT = 30
    }
}