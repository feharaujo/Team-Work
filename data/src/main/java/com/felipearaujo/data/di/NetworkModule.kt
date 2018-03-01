package com.felipearaujo.data.di

import android.content.Context
import com.felipearaujo.data.DataRepository
import com.felipearaujo.data.DataRepositoryImp
import com.felipearaujo.data.URL_BASE
import com.felipearaujo.data.local.LocalRepository
import com.felipearaujo.data.local.LocalRepositoryImp
import com.felipearaujo.data.remote.ApiService
import com.felipearaujo.data.remote.RemoteRepository
import com.felipearaujo.data.remote.RemoteRepositoryImp
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import io.realm.Realm
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by felipearaujo on 28/02/18.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun prividesGson(): Gson {
        val gson = GsonBuilder()
        return gson.create()
    }

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(URL_BASE)
            .build()


    @Provides
    @Singleton
    fun providesPicasso(context: Context): Picasso =
            Picasso.Builder(context)
                    .loggingEnabled(true)
                    .build()

    /**
     * Repository (local and remote)
     */
    @Provides
    @Singleton
    fun providesRepository(
            appContext: Context, remote: RemoteRepository, local: LocalRepository
    ): DataRepository = DataRepositoryImp(appContext, remote, local)

    /**
     * Remote repository
     */
    @Provides
    @Singleton
    fun providesRemoteRepository(service: ApiService, localRepository: LocalRepository): RemoteRepository =
            RemoteRepositoryImp(service, localRepository)

    /**
     * Local repository
     */
    @Provides
    @Singleton
    fun providesLocalRepository(realm: Realm): LocalRepository = LocalRepositoryImp(realm)


    @Provides
    @Singleton
    fun providesApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesRealm(appContext: Context): Realm {
        Realm.init(appContext)
        return Realm.getDefaultInstance()
    }


}