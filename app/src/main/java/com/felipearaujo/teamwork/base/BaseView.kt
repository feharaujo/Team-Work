package com.felipearaujo.teamwork.base

import android.annotation.SuppressLint
import android.widget.FrameLayout

/**
 * Created by felipearaujo on 04/03/18.
 */
@SuppressLint("ViewConstructor")
abstract class BaseView constructor(activity: BaseActivity): FrameLayout(activity) {

}