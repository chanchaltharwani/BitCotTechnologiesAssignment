package com.example.bitcottechnologiesassignment.api

import com.example.bitcottechnologiesassignment.model.ShowResponseModel
import com.example.bitcottechnologiesassignment.model.ShowResponseModelItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
   // Makes a GET request to search for TV shows based on a query.
    @GET("search/shows")
    suspend fun searchShows(@Query("q") query: String): Response<List<ShowResponseModelItem>>

}