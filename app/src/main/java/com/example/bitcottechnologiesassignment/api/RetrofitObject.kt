package com.example.bitcottechnologiesassignment.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Object to provide a Retrofit instance.
 */
@Module
@InstallIn(SingletonComponent::class)
object RetrofitObject {

    // Base URL for the API
    val Baseurl = "https://api.tvmaze.com/"

    /**
     * Function to get the Retrofit instance.
     *
     * @return A Retrofit instance configured with the base URL and Gson converter factory.
     */
    @Provides
    @Singleton
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Baseurl) // Set the base URL for the API
            .addConverterFactory(GsonConverterFactory.create()) // Add Gson converter factory for JSON parsing
            .build() // Build the Retrofit instance
    }
    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
}
