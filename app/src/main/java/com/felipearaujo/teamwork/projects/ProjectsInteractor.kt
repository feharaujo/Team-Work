package com.felipearaujo.teamwork.projects

import com.felipearaujo.data.DataRepository
import com.felipearaujo.model.Response
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by felipearaujo on 04/03/18.
 */
class ProjectsInteractor
@Inject constructor(private val repository: DataRepository) {

    fun fetchProjects(): Observable<Response> {
        return repository.fetchProjects()
    }

}