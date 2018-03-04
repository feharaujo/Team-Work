package com.felipearaujo.teamwork.projects

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import com.felipearaujo.teamwork.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * Created by felipearaujo on 04/03/18.
 */
class ProjectsPresenter
@Inject constructor(
        val view: ProjectsView, val interactor: ProjectsInteractor
) : BasePresenter() {

    private val disposeBag: CompositeDisposable = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun onAttach() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun onDetach() {
        disposeBag.clear();
    }

}