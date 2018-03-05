package com.felipearaujo.data

import com.felipearaujo.model.Response
import io.reactivex.Observable

/**
 * Created by felipearaujo on 28/02/18.
 */
interface DataRepository {

    fun fetchProjects() : Observable<Response>

}