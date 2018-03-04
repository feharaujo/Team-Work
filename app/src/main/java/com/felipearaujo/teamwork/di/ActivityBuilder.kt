package com.felipearaujo.teamwork.di

import com.felipearaujo.teamwork.projects.ProjectsActivity
import com.felipearaujo.teamwork.projects.dagger.ProjectsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by felipearaujo on 28/02/18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [ProjectsModule::class])
    abstract fun bindProjectsActivity(): ProjectsActivity

}