package com.felipearaujo.teamwork.activities.dagger

import com.felipearaujo.data.DataRepository
import com.felipearaujo.teamwork.activities.EXTRA_POSITION
import com.felipearaujo.teamwork.activities.ProjectActActivity
import com.felipearaujo.teamwork.activities.ProjectActContract
import com.felipearaujo.teamwork.activities.ProjectActPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

/**
 * Created by felipearaujo on 09/03/18.
 */
@Module
class ActivityModule {

    @Provides
    fun providesView(activity: ProjectActActivity): ProjectActContract.View = activity

    @Provides
    fun providesPresenter(view: ProjectActContract.View, dataRepository: DataRepository, position: Int):
            ProjectActContract.Presenter = ProjectActPresenter(view, dataRepository, position)

    @Provides
    fun providesProjectPosition(activity: ProjectActActivity): Int {
        return activity.intent.getIntExtra(EXTRA_POSITION, -1)
    }

}