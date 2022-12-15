package com.example.kms.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kms.R
import com.example.kms.model.GenreModel
import com.squareup.picasso.Picasso

internal class GenreAdapter(private val list: ArrayList<GenreModel>) :
    RecyclerView.Adapter<GenreAdapter.MyViewHolder>() {


    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgGenre: ImageView = view.findViewById(R.id.img_genre)
        val nameGenre: TextView = view.findViewById(R.id.name_genre)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_genre, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = list[position]
        Picasso.get().load(item.linkImg).into(holder.imgGenre)
        holder.nameGenre.text = item.name

    }

    override fun getItemCount(): Int {
        return list.size
    }


}