package com.example.kms.api

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request.Method
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.kms.adapter.TMIAdapter
import com.example.kms.model.TMIModel
import org.json.JSONException

class TMIApi(requestQueue: RequestQueue, recyclerView: RecyclerView) {


    private val url =
        "http://moviestreamingapi.mywebcommunity.org//getInformationHome.php?category_name=top_movie_new"
    private val requestQueue: RequestQueue
    private val recyclerView: RecyclerView
    private var list: ArrayList<TMIModel> = ArrayList()
    private lateinit var adpter: TMIAdapter


    init {
        this.requestQueue = requestQueue
        this.recyclerView = recyclerView
    }


    fun getTMI() {
        val jsonObjectRequest = JsonObjectRequest(Method.GET, url, null,
            Response.Listener { response ->
                try {
                    val jsonArray = response.getJSONArray("movie_streaming")
                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val item = TMIModel()
                        item.linkImg = jsonObject.getString("link_img")
                        item.name = jsonObject.getString("name")
                        item.id = jsonObject.getString("id")
                        item.rank = jsonObject.getString("rank")
                        item.time = jsonObject.getString("time")


                        list.add(item)
                        adpter = TMIAdapter(list)
                        recyclerView.adapter = adpter
                        Log.e("Log", "ok")
                    }
                } catch (_: JSONException) {
                    Log.e("Log", "catch")
                }
            },
            Response.ErrorListener {
                Log.e("Log", "error")
            })
        requestQueue.add(jsonObjectRequest)
    }

}