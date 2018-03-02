package com.felipearaujo.teamwork.di

import com.felipearaujo.teamwork.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by felipearaujo on 28/02/18.
 */
@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity

}