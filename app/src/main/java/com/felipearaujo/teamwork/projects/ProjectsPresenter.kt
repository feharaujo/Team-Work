package com.felipearaujo.teamwork.projects

import com.felipearaujo.teamwork.base.BasePresenter


/**
 * Created by felipearaujo on 04/03/18.
 */

class ProjectsPresenter
constructor(override var view: ProjectsContract.View?) : BasePresenter<ProjectsContract.View>(), ProjectsContract.Presenter {

    override fun onCreated() {

    }


    override fun fetchProjects() {

    }

}

/*
class ProjectsPresenter
@Inject constructor(
        val view: ProjectsView, val interactor: ProjectsInteractor
) : BasePresenter<ProjectsContract.View>(), LifecycleObserver {

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


}*/
