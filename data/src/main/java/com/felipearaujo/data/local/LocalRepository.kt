package com.felipearaujo.data.local

import com.felipearaujo.data.DataRepository
import com.felipearaujo.model.Response
import io.reactivex.Single

/**
 * Created by felipearaujo on 28/02/18.
 */
interface LocalRepository : DataRepository {

    fun saveCacheData(cache: Single<Response>)


}