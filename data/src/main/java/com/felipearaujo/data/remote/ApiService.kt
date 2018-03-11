package com.felipearaujo.data.remote

import com.felipearaujo.model.Response
import com.felipearaujo.model.ResponseActivity
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by felipearaujo on 28/02/18.
 */
interface ApiService {

    @GET("projects.json")
    fun fetchAllProject() : Single<Response>

    @GET("projects.json")
    fun fetchAllProject2() : Observable<Response>

    @GET("projects/{id}/latestactivity.json")
    fun fetchActivities(@Path("id") id: String) : Observable<ResponseActivity>

}