package com.example.bitcottechnologiesassignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bitcottechnologiesassignment.repository.ShowRepository

class ShowViewModelFactory(val repository: ShowRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShowViewModel(repository) as T
    }
}