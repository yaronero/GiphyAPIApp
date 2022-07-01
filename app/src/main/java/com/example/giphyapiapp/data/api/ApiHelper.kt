package com.example.giphyapiapp.data.api

import com.example.giphyapiapp.model.DataResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHelper {

    @GET("v1/gifs/search?api_key=$API_KEY&limit=$LIMIT&offset=$OFFSET&rating=g&lang=en")
    suspend fun getAllGifsByName(
        @Query("q") name: String
    ): Response<DataResult>

    companion object{
        private const val API_KEY = "nXEaLef6vZx7CHAiZTTy2gWkqOPe4rUO"
        private const val LIMIT = 30
        private const val OFFSET = 0
    }
}