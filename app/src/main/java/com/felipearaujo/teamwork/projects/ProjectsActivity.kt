package com.felipearaujo.teamwork.projects

import android.os.Bundle
import com.felipearaujo.teamwork.base.BaseActivity
import javax.inject.Inject

class ProjectsActivity : BaseActivity() {

    @Inject
    lateinit var view: ProjectsView
    @Inject
    lateinit var presenter: ProjectsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view)
    }

    override fun onResume() {
        super.onResume()

        presenter.onAttach()
    }

    override fun onPause() {
        super.onPause()

        presenter.onDetach()
    }
}
