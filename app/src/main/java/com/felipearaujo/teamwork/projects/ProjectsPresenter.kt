package com.felipearaujo.teamwork.projects

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import com.felipearaujo.data.DataRepository
import com.felipearaujo.model.ProjectsItem
import com.felipearaujo.teamwork.base.BasePresenter
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

    @OnLifecycleEvent(value = Lifecycle.Event.ON_RESUME)
    fun onCreate() {
        disposeBag.add(fetchProjects())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onDestroy() {
        disposeBag.clear()
    }

    override fun fetchProjects(): Disposable {
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
                .subscribeBy(onSuccess = {
                    val result = it.projects as List<ProjectsItem>
                    view?.updateProjectsData(result)
                }, onError = {
                    Log.v(" ", "${it.message}")
                })

    }


}
