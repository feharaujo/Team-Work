package com.felipearaujo.teamwork.activities.dagger

import com.felipearaujo.data.DataRepository
import com.felipearaujo.teamwork.activities.ProjectActActivity
import com.felipearaujo.teamwork.activities.ProjectActContract
import com.felipearaujo.teamwork.activities.ProjectActPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by felipearaujo on 09/03/18.
 */
@Module
class ActivityModule {

    @Provides
    fun providesView(activity: ProjectActActivity): ProjectActContract.View = activity

    @Provides
    fun providesPresenter(view: ProjectActContract.View, dataRepository: DataRepository):
            ProjectActContract.Presenter = ProjectActPresenter(view, dataRepository)

}