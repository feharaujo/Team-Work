package com.felipearaujo.data.remote

import com.felipearaujo.data.local.LocalRepository

/**
 * Created by felipearaujo on 28/02/18.
 */
class RemoteRepositoryImp(
        private val service: ApiService,
        private val localRepository: LocalRepository
) : RemoteRepository {



}