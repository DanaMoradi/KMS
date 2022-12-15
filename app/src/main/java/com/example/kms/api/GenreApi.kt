package com.example.kms.api

import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request.Method
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.kms.adapter.GenreAdapter
import com.example.kms.model.GenreModel
import org.json.JSONException

class GenreApi(
    requestQueue: RequestQueue,
    recyclerView: RecyclerView
) {

    private val link = "http://moviestreamingapi.mywebcommunity.org/getGenre.php"
    private var requestQueue: RequestQueue
    private var list: ArrayList<GenreModel> = ArrayList()
    private var recyclerView: RecyclerView

    private lateinit var genreAdapter: GenreAdapter


    init {
        this.requestQueue = requestQueue
        this.recyclerView = recyclerView
    }


    fun getGenre() {
        val jsonObjectRequest = JsonObjectRequest(Method.GET, link, null,
            Response.Listener { response ->
                try {
                    val jsonArray = response.getJSONArray("movie_streaming")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val genre = GenreModel()
                        genre.name = jsonObject.getString("name")
                        genre.id = jsonObject.getString("id")
                        genre.linkImg = jsonObject.getString("link_img")

                        list.add(genre)
                        genreAdapter = GenreAdapter(list)
                        recyclerView.adapter = genreAdapter
                    }

                } catch (_: JSONException) {

                }

            }, Response.ErrorListener { })

        requestQueue.add(jsonObjectRequest)

    }

}