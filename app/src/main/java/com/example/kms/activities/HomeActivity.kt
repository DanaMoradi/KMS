package com.example.kms.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.kms.R
import com.example.kms.api.*

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getGenre()
        getTMI() //TMI = TOP MOVIE IMDB
        getNewMovie()
        getSeries()
        getPopular()

    }

    private fun getTMI() {
        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        val recyclerView: RecyclerView = findViewById(R.id.top_movie_imdb_recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val api = TMIApi(requestQueue, recyclerView)
        api.getTMI()
    }

    private fun getGenre() {
        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        val recyclerView: RecyclerView = findViewById(R.id.genre_recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val api = GenreApi(requestQueue, recyclerView)
        api.getGenre()
    }

    private fun getNewMovie() {
        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        val recyclerView: RecyclerView = findViewById(R.id.new_movie_recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val api = NewMovieApi(requestQueue, recyclerView)
        api.getNewMovie()
    }

    private fun getSeries() {
        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        val recyclerView: RecyclerView = findViewById(R.id.series_recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val api = SeriesApi(requestQueue, recyclerView)
        api.getSeries()
    }

    private fun getPopular() {
        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        val recyclerView: RecyclerView = findViewById(R.id.popular_recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val api = PopularApi(requestQueue, recyclerView)
        api.getPopular()
    }


}