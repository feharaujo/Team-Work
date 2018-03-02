package com.felipearaujo.data.remote

import com.felipearaujo.data.remote.model.Response
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by felipearaujo on 28/02/18.
 */
interface ApiService {

    @GET("projects.json")
    fun fetchAllProject() : Call<Response>

}