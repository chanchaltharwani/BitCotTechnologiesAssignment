package com.example.bitcottechnologiesassignment.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {

    val Baseurl = "https://api.tvmaze.com/"
    fun getInstance(): Retrofit {

        return Retrofit.Builder().baseUrl(Baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}