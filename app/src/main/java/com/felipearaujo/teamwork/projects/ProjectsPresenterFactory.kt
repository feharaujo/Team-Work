package com.felipearaujo.teamwork.projects

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Singleton

/**
 * Created by felipearaujo on 04/03/18.
 */
@Suppress("UNCHECKED_CAST")
@Singleton
class ProjectsPresenterFactory
constructor(val view: ProjectsView, val interactor: ProjectsInteractor) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            ProjectsPresenter(view, interactor) as T

}