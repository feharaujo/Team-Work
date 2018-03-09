package com.felipearaujo.teamwork.activities

import com.felipearaujo.data.DataRepository
import com.felipearaujo.teamwork.base.BasePresenter
import io.reactivex.disposables.Disposable

/**
 * Created by felipearaujo on 09/03/18.
 */
class ProjectActPresenter
constructor(override var view: ProjectActContract.View?, var dataRepository: DataRepository) :
        BasePresenter<ProjectActContract.View>(), ProjectActContract.Presenter {


    override fun fetchActivity(): Disposable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}