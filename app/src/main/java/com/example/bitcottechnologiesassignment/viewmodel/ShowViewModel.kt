package com.example.bitcottechnologiesassignment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bitcottechnologiesassignment.model.ShowResponseModelItem
import com.example.bitcottechnologiesassignment.repository.ShowRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
/**
 * ViewModel for managing UI-related data for TV shows in a lifecycle-conscious way.
 * Connects the repository to the UI and handles data fetching and error management.
 */
class ShowViewModel(private val repository: ShowRepository) : ViewModel() {
    // LiveData to hold the list of TV shows
    private val _shows = MutableLiveData<List<ShowResponseModelItem>>()
    val shows: LiveData<List<ShowResponseModelItem>> get() = _shows
    // LiveData to hold error messages
    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchShows() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Calls the repository to fetch shows
                val response =
                    repository.searchShows("golden girls")
                if (response.isSuccessful) {
                    // Post the successful response to LiveData
                    _shows.postValue(response.body())
                } else {
                    // post the error response code
                    _error.postValue("Error: ${response.code()}")
                }
            } catch (e: Exception) {
                // Post any exception that occurs during the API call
                _error.postValue(e.message)
            }
        }
    }

}