package com.felipearaujo.teamwork.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

/**
 * Created by felipearaujo on 28/02/18.
 */
@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Performe injection
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
    }

}