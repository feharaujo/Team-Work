package com.felipearaujo.data.remote

import com.felipearaujo.data.local.LocalRepository
import com.felipearaujo.model.Response
import io.reactivex.Observable

/**
 * Created by felipearaujo on 28/02/18.
 */
class RemoteRepositoryImp(
        private val service: ApiService,
        private val localRepository: LocalRepository
) : RemoteRepository {

    override fun fetchProjects(): Observable<Response> {
        return service.fetchAllProject()
    }


}