package com.example.kms.api

import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.kms.adapter.SeriesAdapter
import com.example.kms.model.SeriesModel
import org.json.JSONException

class SeriesApi(requestQueue: RequestQueue, recyclerView: RecyclerView) {

    private val url =
        "http://moviestreamingapi.mywebcommunity.org//getInformationHome.php?category_name=series"


    private val requestQueue: RequestQueue
    private val recyclerView: RecyclerView

    private val list = ArrayList<SeriesModel>()
    lateinit var adapter: SeriesAdapter


    init {
        this.recyclerView = recyclerView
        this.requestQueue = requestQueue
    }


    fun getSeries() {


        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                try {
                    val jsonArray = response.getJSONArray("movie_streaming")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val item = SeriesModel()
                        item.id = jsonObject.getString("id")
                        item.name = jsonObject.getString("name")
                        item.time = jsonObject.getString("time")
                        item.linkImg = jsonObject.getString("link_img")

                        list.add(item)
                        adapter = SeriesAdapter(list)
                        recyclerView.adapter = adapter
                    }
                } catch (_: JSONException) {

                }
            }, Response.ErrorListener {

            })
        requestQueue.add(jsonObjectRequest)
    }


}


