package com.felipearaujo.teamwork.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.os.Bundle


/**
 * Created by felipearaujo on 04/03/18.
 */
abstract class BasePresenter<V : BaseContract.View> : LifecycleObserver, BaseContract.Presenter<V> {

    override var stateBundle = Bundle()

    override fun onAttachLifecycle(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    override fun onDetachLifecycle(lifecycle: Lifecycle) {
        lifecycle.removeObserver(this)
    }

    override fun onAttachView(view: V) {
        this.view = view
    }

    override fun onDetachView() {
        this.view = null
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun onDestroy() {
        stateBundle.clear()
    }

}