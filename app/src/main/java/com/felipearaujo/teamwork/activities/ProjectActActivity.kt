package com.felipearaujo.teamwork.activities

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.felipearaujo.model.ActivityItem
import com.felipearaujo.teamwork.R
import com.felipearaujo.teamwork.base.BaseActivity
import kotlinx.android.synthetic.main.activity_project_act.*
import org.jetbrains.anko.intentFor
import javax.inject.Inject

const val EXTRA_POSITION = "position"

class ProjectActActivity : BaseActivity<ProjectActContract.View, ProjectActContract.Presenter>(), ProjectActContract.View {

    companion object {
        fun start(context: Context, position: Int) {
            context.startActivity(context.intentFor<ProjectActActivity>(EXTRA_POSITION to position))
        }
    }

    @Inject
    override lateinit var presenter: ProjectActContract.Presenter
    @Inject
    lateinit var recyclerViewAdapter: ActivitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_act)

        setupRecyclerView()
    }

    override fun updateActivityData(list: List<ActivityItem>) {
        recyclerViewAdapter.updateItems(list)
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }

    override fun showRecyclerView() {
        rv_activities.visibility = View.VISIBLE
    }

    override fun hideRecyclerView() {
        rv_activities.visibility = View.GONE
    }

    override fun showErrorMessage(message: String) {
        tv_error.text = message
        tv_error.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        rv_activities.setHasFixedSize(true)
        rv_activities.adapter = recyclerViewAdapter
        rv_activities.layoutManager = LinearLayoutManager(this)
        rv_activities.itemAnimator = DefaultItemAnimator()
    }

    override fun initPresenter(): ProjectActContract.Presenter {
        return presenter
    }


}
