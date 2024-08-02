package com.example.bitcottechnologiesassignment.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Object to provide a Retrofit instance.
 */
object RetrofitObject {

    // Base URL for the API
    val Baseurl = "https://api.tvmaze.com/"

    /**
     * Function to get the Retrofit instance.
     *
     * @return A Retrofit instance configured with the base URL and Gson converter factory.
     */
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Baseurl) // Set the base URL for the API
            .addConverterFactory(GsonConverterFactory.create()) // Add Gson converter factory for JSON parsing
            .build() // Build the Retrofit instance
    }
}
