package com.felipearaujo.teamwork.main

import android.os.Bundle
import android.util.Log
import com.felipearaujo.data.remote.ApiService
import com.felipearaujo.data.remote.model.Response
import com.felipearaujo.teamwork.R
import com.felipearaujo.teamwork.base.BaseActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = retrofit.create(ApiService::class.java)
        service.fetchAllProject().enqueue(object : Callback<Response> {
            override fun onFailure(call: Call<Response>?, t: Throwable?) {
                Log.v(" ", " ")
            }

            override fun onResponse(call: Call<Response>?, response: retrofit2.Response<Response>?) {
                Log.v(" ", " ")
            }

        })
    }
}
