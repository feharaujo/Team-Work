package com.felipearaujo.teamwork.projects.dagger

import com.felipearaujo.data.DataRepository
import com.felipearaujo.teamwork.projects.ProjectsActivity
import com.felipearaujo.teamwork.projects.ProjectsInteractor
import com.felipearaujo.teamwork.projects.ProjectsPresenter
import com.felipearaujo.teamwork.projects.ProjectsView
import dagger.Module
import dagger.Provides

/**
 * Created by felipearaujo on 04/03/18.
 */
@Module
class ProjectsModule {

    @Provides
    fun providesView(activity: ProjectsActivity) =
            ProjectsView(activity)

    @Provides
    fun providesInteractor(repository: DataRepository) =
            ProjectsInteractor(repository)

    @Provides
    fun providesPresenter(view: ProjectsView, interactor: ProjectsInteractor) =
            ProjectsPresenter(view, interactor)


}