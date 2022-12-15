package com.example.kms.api

import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request.Method
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.kms.adapter.NewMoveAdapter
import com.example.kms.model.NewMovieModel
import org.json.JSONException

class NewMovieApi(requestQueue: RequestQueue, recyclerView: RecyclerView) {


    private val url =
        "http://moviestreamingapi.mywebcommunity.org//getInformationHome.php?category_name=movie_new"

    private val requestQueue: RequestQueue
    private val recyclerView: RecyclerView

    private val list = ArrayList<NewMovieModel>()
    private lateinit var newMovieAdapter: NewMoveAdapter

    init {
        this.requestQueue = requestQueue
        this.recyclerView = recyclerView
    }


    fun getNewMovie() {

        val jsonObjectRequest = JsonObjectRequest(Method.GET, url, null,
            Response.Listener { response ->
                try {
                    val jsonArray = response.getJSONArray("movie_streaming")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        val item = NewMovieModel()
                        item.id = jsonObject.getString("id")
                        item.name = jsonObject.getString("name")
                        item.time = jsonObject.getString("time")
                        item.linkImg = jsonObject.getString("link_img")

                        list.add(item)
                        newMovieAdapter = NewMoveAdapter(list)
                        recyclerView.adapter = newMovieAdapter
                    }
                } catch (_: JSONException) {

                }
            }, Response.ErrorListener {

            })
        requestQueue.add(jsonObjectRequest)
    }


}