package com.felipearaujo.teamwork.base

import android.annotation.SuppressLint
import android.app.Activity
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import android.widget.FrameLayout

/**
 * Created by felipearaujo on 04/03/18.
 */
@SuppressLint("ViewConstructor")
abstract class BaseView constructor(activity: BaseActivity): FrameLayout(activity), LifecycleOwner {

    val lifecyclerRegistry = LifecycleRegistry(activity)

    override fun getLifecycle(): Lifecycle {
        return lifecyclerRegistry;
    }

}