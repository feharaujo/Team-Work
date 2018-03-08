package com.felipearaujo.teamwork.projects

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.felipearaujo.model.ProjectsItem
import com.felipearaujo.teamwork.R
import com.felipearaujo.teamwork.base.BaseActivity
import kotlinx.android.synthetic.main.activity_projects.*
import javax.inject.Inject

class ProjectsActivity : BaseActivity<ProjectsContract.View, ProjectsContract.Presenter>(), ProjectsContract.View {


    @Inject
    override lateinit var presenter: ProjectsContract.Presenter

    val recyclerViewAdapter: ProjectsAdapter by lazy {
        ProjectsAdapter()
    }

    override fun initPresenter(): ProjectsContract.Presenter {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)

        setupRecyclerView()
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }

    override fun showRecyclerView() {
        rv_projects.visibility = View.VISIBLE
    }

    override fun hideRecyclerView() {
        rv_projects.visibility = View.GONE
    }

    override fun showErrorMessage(message: String) {

    }

    override fun updateProjectsData(list: List<ProjectsItem>) {
        recyclerViewAdapter.updateItems(list)
    }

    private fun setupRecyclerView() {
        rv_projects.setHasFixedSize(true)
        rv_projects.adapter = recyclerViewAdapter
        rv_projects.layoutManager = LinearLayoutManager(this)
        rv_projects.itemAnimator = DefaultItemAnimator()
    }

}
