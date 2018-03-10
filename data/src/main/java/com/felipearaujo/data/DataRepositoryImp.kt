package com.felipearaujo.data

import android.content.Context
import android.net.ConnectivityManager
import com.felipearaujo.data.local.LocalRepository
import com.felipearaujo.data.remote.RemoteRepository
import com.felipearaujo.model.Response
import io.reactivex.Single


/**
 * Created by felipearaujo on 28/02/18.
 */
class DataRepositoryImp constructor(
        private val appContext: Context,
        private val remoteRepository: RemoteRepository,
        private val localRepository: LocalRepository
) : DataRepository {

    override fun fetchProjects(): Single<Response> {
        return if(isNetworkConnected()) {
            remoteRepository.fetchProjects()
        } else {
            localRepository.fetchProjects()
        }
    }

    /**
     * Check connection
     */
    private fun isNetworkConnected(): Boolean {
        val cm = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }

}