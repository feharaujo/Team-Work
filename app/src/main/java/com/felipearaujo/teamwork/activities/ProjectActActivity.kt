package com.felipearaujo.teamwork.activities

import android.os.Bundle
import com.felipearaujo.model.ActivityItem
import com.felipearaujo.teamwork.R
import com.felipearaujo.teamwork.base.BaseActivity
import javax.inject.Inject

class ProjectActActivity : BaseActivity<ProjectActContract.View, ProjectActContract.Presenter>(), ProjectActContract.View {

    @Inject
    override lateinit var presenter: ProjectActContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project_act)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showRecyclerView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideRecyclerView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateActivityData(list: List<ActivityItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun showErrorMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initPresenter(): ProjectActContract.Presenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
