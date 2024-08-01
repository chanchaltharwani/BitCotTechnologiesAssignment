package com.example.bitcottechnologiesassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bitcottechnologiesassignment.R
import com.example.bitcottechnologiesassignment.databinding.ItemShowBinding
import com.example.bitcottechnologiesassignment.model.ShowResponseModelItem

class ShowAdapter(private val shows: List<ShowResponseModelItem>) :
    RecyclerView.Adapter<ShowAdapter.ViewHolder>() {
    // private val baseUrl = "https://dummy.restapiexample.com"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_show, parent, false)

        val binding = ItemShowBinding.bind(view)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val showItem = shows[position].show
        holder.binding.textViewName.text = showItem?.name

        Glide.with(holder.itemView.context)
            .load(showItem?.image?.medium)
            .into(holder.binding.imageView)


    }

    override fun getItemCount(): Int {
        return shows.size
    }

    class ViewHolder(val binding: ItemShowBinding) : RecyclerView.ViewHolder(binding.root)
}