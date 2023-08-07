package com.example.myapplication.api

import com.example.myapplication.model.news
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface apiRequest {
    companion object{
        val api: apiRequest = Retrofit.Builder()
            .baseUrl("https://api.currentsapi.services")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(apiRequest::class.java)
    }
    @GET("/v1/latest-news?languageits&apiKey=xt-RDMYCM6SaDDm0LzdCLHUn5SpKY4rMCiJ9juY0gcPbMtDv")
    fun getNew(): Call<news>
}