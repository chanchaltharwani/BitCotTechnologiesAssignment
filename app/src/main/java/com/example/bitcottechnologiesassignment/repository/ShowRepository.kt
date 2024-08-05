package com.example.bitcottechnologiesassignment.repository

import com.example.bitcottechnologiesassignment.api.ApiInterface
import com.example.bitcottechnologiesassignment.model.ShowResponseModelItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

/**
 * Repository class that handles data operations for TV shows.
 * Acts as a mediator between the ViewModel and the API interface.
 */
class ShowRepository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun searchShows(query: String): Response<List<ShowResponseModelItem>> {
        return withContext(Dispatchers.IO) {
            try {
                // Calls the API to fetch shows based on the query
                apiInterface.searchShows(query)
            } catch (e: Exception) {
                // Throws an IOException if there is an error during the API call
                throw IOException("Error Fetching in api")
            }
        }
    }
}