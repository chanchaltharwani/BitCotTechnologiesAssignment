package com.example.bitcottechnologiesassignment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bitcottechnologiesassignment.model.Show
import com.example.bitcottechnologiesassignment.model.ShowResponseModel
import com.example.bitcottechnologiesassignment.model.ShowResponseModelItem
import com.example.bitcottechnologiesassignment.repository.ShowRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowViewModel(private val repository:ShowRepository):ViewModel() {

    private val _shows = MutableLiveData<List<ShowResponseModelItem>>()
    val shows: LiveData<List<ShowResponseModelItem>> get() = _shows

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchShows() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.searchShows("golden girls") // Or any default query if needed
                if (response.isSuccessful) {
                    _shows.postValue(response.body())
                } else {
                    Log.d("Errormessage","Error: ${response.code()}")
                    _error.postValue("Error: ${response.code()}")
                }
            } catch (e: Exception) {
                _error.postValue(e.message)
                Log.d("ShowViewModel", e.toString())
            }
        }
    }

}