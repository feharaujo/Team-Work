package com.felipearaujo.teamwork.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by felipearaujo on 28/02/18.
 */
@Module
class AppModule {

    @Provides
    @Singleton
    fun providesApplicationContext(app: Application): Context = app

}