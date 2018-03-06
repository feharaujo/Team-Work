package com.felipearaujo.teamwork.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

/**
 * Created by felipearaujo on 28/02/18.
 */
abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> : AppCompatActivity(), BaseContract.View {

    abstract var presenter: P
    //abstract var viewModel: BaseViewModel<V, P>

    private val lifecyclerRegistry = LifecycleRegistry(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        // Performe injection
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProviders.of(this).get(BaseViewModel<V, P>()::class.java)
        //ViewModelProviders.of(activity).get(BaseViewModel<ProjectsContract.View, ProjectsContract.Presenter>()::class.java)

        presenter = initPresenter()
        viewModel.presenter = presenter
        presenter.onAttachView(this as V)
        presenter.onCreated()
    }

    override fun getLifecycle(): Lifecycle {
        return lifecyclerRegistry
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDetachLifecycle(lifecycle)
        presenter.onDetachView()
    }

    abstract fun initPresenter(): P

}