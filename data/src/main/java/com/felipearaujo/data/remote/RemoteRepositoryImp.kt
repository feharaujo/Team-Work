package com.felipearaujo.data.remote

import com.felipearaujo.data.local.LocalRepository
import com.felipearaujo.model.ActivityItem
import com.felipearaujo.model.ProjectsItem
import com.felipearaujo.model.Response
import com.felipearaujo.model.ResponseActivity
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction

/**
 * Created by felipearaujo on 28/02/18.
 */
class RemoteRepositoryImp(
        private val service: ApiService,
        private val localRepository: LocalRepository
) : RemoteRepository {


    override fun fetchProjects(): Single<Response> {
        return service.fetchAllProject2()
                .flatMapIterable {
                    it.projects
                }
                .flatMap {
                    Observable.zip(
                            Observable.just(it),
                            service.fetchActivities(it.id!!),
                            BiFunction<ProjectsItem, ResponseActivity, ProjectsItem> { first: ProjectsItem, second: ResponseActivity ->
                                first.setActivitiesList(second.activity as List<ActivityItem>)
                            }
                    )
                }
                .toList()
                .map { Response("ok", it.toList()) }


    }

}