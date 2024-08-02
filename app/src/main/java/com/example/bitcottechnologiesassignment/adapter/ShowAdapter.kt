package com.example.bitcottechnologiesassignment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bitcottechnologiesassignment.R
import com.example.bitcottechnologiesassignment.databinding.ItemShowBinding
import com.example.bitcottechnologiesassignment.model.ShowResponseModelItem

/**
 * RecyclerView Adapter for displaying a list of TV shows.
 */
class ShowAdapter(private var shows: List<ShowResponseModelItem?>) :
    RecyclerView.Adapter<ShowAdapter.ViewHolder>() {
    // Keep a copy of the original list for filtering purposes
    private var originalShows: List<ShowResponseModelItem?> = shows

    /**
     * Called when RecyclerView needs a new ViewHolder of the given type to represent an item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_show, parent, false)
        val binding = ItemShowBinding.bind(view)
        return ViewHolder(binding)
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val showItem = shows[position]?.show
        holder.binding.textViewName.text = showItem?.name
        holder.binding.textViewId.text = "ID: ${showItem?.id}"
        // Load show image using Glide
        Glide.with(holder.itemView.context).load(showItem?.image?.medium)
            .into(holder.binding.imageView)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     */
    override fun getItemCount(): Int {
        return shows.size
    }

    /**
     * Filters the list of shows by genre and updates the RecyclerView.
     */
    @SuppressLint("NotifyDataSetChanged")
    // Filter shows by genre
    fun filterShowsByGenre(genre: String) {
        shows = if (genre.isEmpty()) {
            originalShows
        } else {
            originalShows.filter {
                it?.show?.genres?.any { g -> g?.equals(genre, ignoreCase = true) == true } == true
            }
        }
        notifyDataSetChanged()
    }

    /**
     * ViewHolder class to hold the view for each item.
     */
    class ViewHolder(val binding: ItemShowBinding) : RecyclerView.ViewHolder(binding.root)
}
