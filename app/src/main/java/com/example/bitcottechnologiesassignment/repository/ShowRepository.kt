package com.example.bitcottechnologiesassignment.repository

import com.example.bitcottechnologiesassignment.api.ApiInterface
import com.example.bitcottechnologiesassignment.model.ShowResponseModelItem
import retrofit2.Response

class ShowRepository(private val apiInterface: ApiInterface) {

    suspend fun searchShows(query: String): Response<List<ShowResponseModelItem>> {
        return apiInterface.searchShows(query)
    }
}