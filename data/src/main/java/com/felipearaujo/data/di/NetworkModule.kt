package com.felipearaujo.data.di

import android.content.Context
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.felipearaujo.data.*
import com.felipearaujo.data.local.LocalRepository
import com.felipearaujo.data.local.LocalRepositoryImp
import com.felipearaujo.data.remote.ApiService
import com.felipearaujo.data.remote.BasicAuthInterceptor
import com.felipearaujo.data.remote.RemoteRepository
import com.felipearaujo.data.remote.RemoteRepositoryImp
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import io.realm.Realm
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

/**
 * Created by felipearaujo on 28/02/18.
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesAuthInterceptor() = BasicAuthInterceptor(USERNAME, PASSWORD)

    @Provides
    @Singleton
    fun providesOKHttpClient(interceptor: BasicAuthInterceptor) = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


    @Provides
    @Singleton
    fun providesJacksonConverter() =
            JacksonConverterFactory.create(
                    jacksonObjectMapper().registerModule(KotlinModule())
            )


    @Provides
    @Singleton
    fun providesRetrofit(jackson: JacksonConverterFactory, client: OkHttpClient): Retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(jackson)
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