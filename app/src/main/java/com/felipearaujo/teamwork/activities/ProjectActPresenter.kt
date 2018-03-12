package com.felipearaujo.teamwork.activities

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.felipearaujo.data.DataRepository
import com.felipearaujo.data.GENERIC_ERROR_MSG
import com.felipearaujo.model.ActivityItem
import com.felipearaujo.model.Response
import com.felipearaujo.teamwork.base.BasePresenter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by felipearaujo on 09/03/18.
 */
class ProjectActPresenter
constructor(override var view: ProjectActContract.View?, var dataRepository: DataRepository, val position: Int) :
        BasePresenter<ProjectActContract.View>(), ProjectActContract.Presenter {


    private val disposeBag: CompositeDisposable = CompositeDisposable()

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    fun onCreate() {
        disposeBag.add(fetchActivity(position))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onDestroy() {
        disposeBag.clear()
    }

    override fun fetchActivity(position: Int): Disposable {
        return requestProjectsObservable()
                .subscribeBy(onSuccess = {
                    val result = it.projects?.get(position)
                    if (result?.activity != null) {
                        view?.updateActivityData(result.activity as List<ActivityItem>)
                    } else {
                        view?.showErrorMessage(GENERIC_ERROR_MSG)
                    }

                }, onError = {
                    view?.showErrorMessage(GENERIC_ERROR_MSG)
                })
    }

    private fun requestProjectsObservable(): Single<Response> {
        return dataRepository.fetchProjects()
                .doOnSubscribe {
                    view?.showLoading()
                    view?.hideRecyclerView()
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterSuccess {
                    view?.hideLoading()
                    view?.showRecyclerView()
                }
                .doOnError {
                    view?.hideLoading()
                    view?.showErrorMessage(GENERIC_ERROR_MSG)
                }
    }
}