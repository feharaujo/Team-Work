package com.felipearaujo.teamwork

import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection

/**
 * Created by felipearaujo on 28/02/18.
 */
open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // Performe injection
        AndroidSupportInjection.inject(this)

        super.onCreate(savedInstanceState)
    }

}