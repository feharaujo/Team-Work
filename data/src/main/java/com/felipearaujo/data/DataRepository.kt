package com.felipearaujo.data

import com.felipearaujo.model.Response
import io.reactivex.Single

/**
 * Created by felipearaujo on 28/02/18.
 */
interface DataRepository {

    fun fetchProjects() : Single<Response>

}