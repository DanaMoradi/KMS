package com.example.kms.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kms.R
import com.example.kms.model.SeriesModel
import com.squareup.picasso.Picasso

class SeriesAdapter(private val list: ArrayList<SeriesModel>) :
    RecyclerView.Adapter<SeriesAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.name)
        val time: TextView = view.findViewById(R.id.time)
        val img: ImageView = view.findViewById(R.id.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_series, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = list[position]
        holder.name.text = item.name
        holder.time.text = item.time
        Picasso.get().load(item.linkImg).into(holder.img)

    }

    override fun getItemCount(): Int {
        return list.size
    }


}