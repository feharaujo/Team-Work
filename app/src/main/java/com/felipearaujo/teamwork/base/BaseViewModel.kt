package com.felipearaujo.teamwork.base

import android.arch.lifecycle.ViewModel

/**
 * Created by felipearaujo on 05/03/18.
 */
class BaseViewModel<V : BaseContract.View, P : BaseContract.Presenter<V>> : ViewModel() {

    var presenter: P? = null

    override fun onCleared() {
        super.onCleared()

        presenter?.onPresenterDestroy()
        presenter = null
    }

}