package com.felipearaujo.data

import android.content.Context
import android.net.ConnectivityManager
import com.felipearaujo.data.local.LocalRepository
import com.felipearaujo.data.remote.RemoteRepository


/**
 * Created by felipearaujo on 28/02/18.
 */
class DataRepositoryImp constructor(
        private val appContext: Context,
        private val remoteRepository: RemoteRepository,
        private val localRepository: LocalRepository
) : DataRepository {


    /**
     * Check connection
     */
    private fun isNetworkConnected(): Boolean {
        val cm = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }

}