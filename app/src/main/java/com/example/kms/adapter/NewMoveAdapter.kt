package com.example.kms.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kms.R
import com.example.kms.model.NewMovieModel
import com.squareup.picasso.Picasso

class NewMoveAdapter(private val list: ArrayList<NewMovieModel>) :
    RecyclerView.Adapter<NewMoveAdapter.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.name)
        val time = view.findViewById<TextView>(R.id.time)
        val img = view.findViewById<ImageView>(R.id.img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_new_movie, parent, false)
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