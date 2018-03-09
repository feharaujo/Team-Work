package com.felipearaujo.teamwork.activities

import com.felipearaujo.model.ActivityItem
import com.felipearaujo.teamwork.base.BaseContract
import io.reactivex.disposables.Disposable

/**
 * Created by felipearaujo on 06/03/18.
 */
class ProjectActContract {

    interface View : BaseContract.View {

        fun showLoading()

        fun hideLoading()

        fun showRecyclerView()

        fun hideRecyclerView()

        fun updateActivityData(list: List<ActivityItem>)

        fun showErrorMessage(message: String)

    }

    interface Presenter: BaseContract.Presenter<ProjectActContract.View> {

        fun fetchActivity(): Disposable

    }

}