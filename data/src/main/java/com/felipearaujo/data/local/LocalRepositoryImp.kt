package com.felipearaujo.data.local

import android.accounts.NetworkErrorException
import android.content.SharedPreferences
import com.fasterxml.jackson.databind.ObjectMapper
import com.felipearaujo.data.GENERIC_ERROR_MSG
import com.felipearaujo.model.Response
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers


/**
 * Created by felipearaujo on 28/02/18.
 */
private const val RESPONSE_KEY = "RESPONSE_KEY"


/**
 * Best approach : Use a database (Room, Realm)
 * For simplicity a SharedPreferences will be used
 */
class LocalRepositoryImp(private val preferences: SharedPreferences) : LocalRepository {

    override fun saveCacheData(cache: Single<Response>) {
        cache.observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    val mapper = ObjectMapper()
                    val json = mapper.writeValueAsString(it)

                    preferences.edit().putString(RESPONSE_KEY, json).apply()
                }, {
                    it.printStackTrace()
                })
    }

    override fun fetchProjects(): Single<Response> {
        val json = preferences.getString(RESPONSE_KEY, null)

        return if (json == null) {
            Single.error<Response>(Throwable(NetworkErrorException(GENERIC_ERROR_MSG)))
        } else {
            val response = ObjectMapper().readValue(json, Response::class.java)
            Single.just(response)
        }
    }

}