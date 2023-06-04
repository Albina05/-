package com.example.lab_2.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_2.R
import com.example.lab_2.model.TravelDestination

class TravelDestinationsAdapter(
    private val travelDestinations: List<TravelDestination>,
    private val navController: NavController
) : RecyclerView.Adapter<TravelDestinationsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val shortDescriptionTextView: TextView = itemView.findViewById(R.id.shortDescriptionTextView)
        val layout: LinearLayout = itemView.findViewById(R.id.layout)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.travel_destination_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val destination = travelDestinations[position]

        Glide.with(holder.imageView.context).load(destination.url).into(holder.imageView)

        holder.nameTextView.text = destination.name
        holder.shortDescriptionTextView.text = destination.shortDescription

        holder.layout.setOnClickListener {
            navController.navigate(MainFragmentDirections.actionMainFragmentToDetailsFragment(destination))
        }
    }

    override fun getItemCount(): Int {
        return travelDestinations.size
    }
}
