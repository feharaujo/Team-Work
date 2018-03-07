package com.felipearaujo.teamwork.projects

import android.os.Bundle
import android.view.View
import com.felipearaujo.model.ProjectsItem
import com.felipearaujo.teamwork.R
import com.felipearaujo.teamwork.base.BaseActivity
import kotlinx.android.synthetic.main.activity_projects.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class ProjectsActivity : BaseActivity<ProjectsContract.View, ProjectsContract.Presenter>(), ProjectsContract.View {

    @Inject
    override lateinit var presenter: ProjectsContract.Presenter

    override fun initPresenter(): ProjectsContract.Presenter {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }

    override fun updateProjectsData(list: List<ProjectsItem>) {
        toast("Size : ${list.size}")
    }

}
