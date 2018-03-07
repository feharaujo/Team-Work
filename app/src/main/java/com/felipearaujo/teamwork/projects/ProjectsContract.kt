package com.felipearaujo.teamwork.projects

import com.felipearaujo.model.ProjectsItem
import com.felipearaujo.teamwork.base.BaseContract
import io.reactivex.disposables.Disposable

/**
 * Created by felipearaujo on 06/03/18.
 */
class ProjectsContract {

    interface View : BaseContract.View {

        fun showLoading()

        fun hideLoading()

        fun updateProjectsData(list: List<ProjectsItem>)

    }

    interface Presenter: BaseContract.Presenter<ProjectsContract.View> {

        fun fetchProjects(): Disposable

    }

}