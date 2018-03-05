package com.felipearaujo.data.local

import com.felipearaujo.model.Response
import io.reactivex.Single
import io.realm.Realm


/**
 * Created by felipearaujo on 28/02/18.
 */
class LocalRepositoryImp(private val realm: Realm) : LocalRepository {
    override fun fetchProjects(): Single<Response> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}