package com.example.giphyapiapp.data.repository

import com.example.giphyapiapp.data.api.ApiHelper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Repository {

    private var gifURLList = mutableListOf<String>()

    suspend fun getGifURLList(): List<String> {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiHelper = retrofit.create(ApiHelper::class.java)

        val response = apiHelper.getAllGifs()

        if(response.isSuccessful){
            val responseBody = response.body()
            responseBody?.result?.forEach {
                gifURLList.add(it.image.originalUrl.url)
            }
        }
        return gifURLList
    }

    companion object{
        const val BASE_URL = "https://api.giphy.com/"
    }
}