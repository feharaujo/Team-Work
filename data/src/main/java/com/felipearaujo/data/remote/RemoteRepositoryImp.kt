package com.felipearaujo.data.remote

import com.felipearaujo.data.local.LocalRepository
import com.felipearaujo.model.Response
import io.reactivex.Single

/**
 * Created by felipearaujo on 28/02/18.
 */
class RemoteRepositoryImp(
        private val service: ApiService,
        private val localRepository: LocalRepository
) : RemoteRepository {

    override fun fetchProjects(): Single<Response> {
        val cache = service.fetchAllProject().cache()
        localRepository.saveCacheData(cache)

        return cache

    }


}