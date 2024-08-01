package com.example.bitcottechnologiesassignment

import android.os.Bundle
import android.util.Log
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
import com.example.bitcottechnologiesassignment.viewmodel.ShowViewModel
import com.example.bitcottechnologiesassignment.viewmodel.ShowViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ShowViewModel
    private lateinit var adapter:ShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)



        val apiInterface = RetrofitObject.getInstance().create(ApiInterface::class.java)
        val repository = ShowRepository(apiInterface)
        val viewModelFactory = ShowViewModelFactory(repository)


        viewModel = ViewModelProvider(this, viewModelFactory).get(ShowViewModel::class.java)

        viewModel.shows.observe(this, Observer { showResponse ->
            showResponse?.let {
                adapter = ShowAdapter(it)
                binding.recyclerView.adapter = adapter
                binding.recyclerView.layoutManager = LinearLayoutManager(this)
            }
        })
        viewModel.error.observe(this, Observer { error ->
            error?.let {it.toString()  }?.let { Log.d("ErrorMessage", it) }
            //error?.let { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
        })
        viewModel.fetchShows()
    }
}