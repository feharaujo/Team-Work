package com.felipearaujo.teamwork.projects

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import com.felipearaujo.teamwork.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by felipearaujo on 04/03/18.
 */
class ProjectsPresenter
@Inject constructor(
        val view: ProjectsView, val interactor: ProjectsInteractor
) : BasePresenter(), LifecycleObserver {

    private val disposeBag: CompositeDisposable = CompositeDisposable()

    init {
        view.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun onAttach() {
        interactor.fetchProjects()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { projectList -> projectList.projects }
                .subscribe({
                    Log.v(" ", "${it.status}")
                }, {
                    Log.v(" ", "${it.message}")
                })
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun onDetach() {
        disposeBag.clear();
    }


}