package com.felipearaujo.teamwork.projects

import android.annotation.SuppressLint
import com.felipearaujo.teamwork.R
import com.felipearaujo.teamwork.base.BaseActivity
import com.felipearaujo.teamwork.base.BaseView
import javax.inject.Inject

/**
 * Created by felipearaujo on 04/03/18.
 */
@SuppressLint("ViewConstructor")
class ProjectsView
@Inject constructor(activity: BaseActivity) : BaseView(activity) {

    init {
        inflate(context, R.layout.activity_projects, this)
    }

}


