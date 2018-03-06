package com.felipearaujo.teamwork.projects.dagger

import com.felipearaujo.teamwork.projects.ProjectsActivity
import com.felipearaujo.teamwork.projects.ProjectsContract
import com.felipearaujo.teamwork.projects.ProjectsPresenter
import dagger.Module
import dagger.Provides



/**
 * Created by felipearaujo on 04/03/18.
 */
@Module
class ProjectsModule {

    @Provides
    fun providesView(activity: ProjectsActivity): ProjectsContract.View = activity

    @Provides
    fun providesPresenter(view: ProjectsContract.View): ProjectsContract.Presenter = ProjectsPresenter(view)

    /*@Provides
    fun providesViewModel(activity: ProjectsActivity) =
            ViewModelProviders.of(activity).get(BaseViewModel<ProjectsContract.View, ProjectsContract.Presenter>()::class.java);*/

}