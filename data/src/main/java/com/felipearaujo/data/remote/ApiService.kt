package com.felipearaujo.data.remote

import com.felipearaujo.model.Response
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by felipearaujo on 28/02/18.
 */
interface ApiService {

    @GET("projects.json")
    fun fetchAllProject() : Observable<Response>

}