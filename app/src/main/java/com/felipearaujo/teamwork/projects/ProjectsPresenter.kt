package com.felipearaujo.teamwork.projects

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.felipearaujo.data.DataRepository
import com.felipearaujo.model.ProjectsItem
import com.felipearaujo.model.Response
import com.felipearaujo.teamwork.base.BasePresenter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers


/**
 * Created by felipearaujo on 04/03/18.
 */
@Suppress("UNCHECKED_CAST")
class ProjectsPresenter
constructor(override var view: ProjectsContract.View?, var dataRepository: DataRepository) :
        BasePresenter<ProjectsContract.View>(), ProjectsContract.Presenter {

    private val disposeBag: CompositeDisposable = CompositeDisposable()

    private val GENERIC_ERROR_MSG = "An error has occurred, please try again"

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    fun onCreate() {
        disposeBag.add(fetchProjects())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onDestroy() {
        disposeBag.clear()
    }

    override fun fetchProjects(): Disposable {
        return requestProjectsObservable()
                .subscribeBy(onSuccess = {
                    val result = it.projects as List<ProjectsItem>
                    view?.updateProjectsData(result)
                }, onError = {
                    view?.showErrorMessage(it.message ?: GENERIC_ERROR_MSG)
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
                    view?.showErrorMessage(it.message ?: GENERIC_ERROR_MSG)
                }
    }


}
