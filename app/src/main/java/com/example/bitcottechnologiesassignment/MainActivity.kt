package com.example.bitcottechnologiesassignment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bitcottechnologiesassignment.adapter.ShowAdapter
import com.example.bitcottechnologiesassignment.api.ApiInterface
import com.example.bitcottechnologiesassignment.api.RetrofitObject
import com.example.bitcottechnologiesassignment.databinding.ActivityMainBinding
import com.example.bitcottechnologiesassignment.repository.ShowRepository
import com.example.bitcottechnologiesassignment.utils.NetworkConnectivity
import com.example.bitcottechnologiesassignment.viewmodel.ShowViewModel
import com.example.bitcottechnologiesassignment.viewmodel.ShowViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding // View binding for the main activity
    private lateinit var viewModel: ShowViewModel // ViewModel for managing UI-related data
    private lateinit var adapter: ShowAdapter // Adapter for RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Initialize API interface and repository
        val apiInterface = RetrofitObject.getInstance().create(ApiInterface::class.java)
        val repository = ShowRepository(apiInterface)
        val viewModelFactory = ShowViewModelFactory(repository)

        // Initialize ViewModel
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShowViewModel::class.java)

        // Show progress bar while data is loading
        binding.progressBar.visibility = View.VISIBLE

        // Observe the shows LiveData from ViewModel
        viewModel.shows.observe(this, Observer { showResponse ->
            showResponse?.let {
                // Set up RecyclerView with the adapter
                adapter = ShowAdapter(it)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(this)
                // Hide progress bar once data is loaded
                binding.progressBar.visibility = View.GONE
            }
        })
        // Observe errors from ViewModel
        viewModel.error.observe(this, Observer { error ->
            error?.let { it.toString() }?.let { Log.d("ErrorMessage", it) }
        })
        // Set up SearchView listener for filtering shows by genre
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filterShowsByGenre(newText.orEmpty())
                return true
            }
        })
        // Check network connectivity before fetching shows
        if (NetworkConnectivity.isInternetAvailable(this)) {
            binding.progressBar.visibility = View.VISIBLE
            viewModel.fetchShows()  // Show progress bar while fetching data
        } else {
            binding.progressBar.visibility = View.GONE // Hide progress bar if no internet
            Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_SHORT).show()

        }
    }
}