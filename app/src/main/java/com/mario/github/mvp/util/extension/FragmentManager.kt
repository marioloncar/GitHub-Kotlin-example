package com.mario.github.mvp.util.extension

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.mario.github.mvp.R

/**
 * Created by mario on 09/07/18.
 */

internal fun FragmentManager.removeFragment(tag: String,
                                            slideIn: Int = R.anim.slide_left,
                                            slideOut: Int = R.anim.slide_right) {
    this.beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(slideIn, slideOut)
            .remove(this.findFragmentByTag(tag))
            .commitNow()
}

internal fun FragmentManager.addFragment(containerViewId: Int,
                                         fragment: Fragment,
                                         tag: String) {
    this.beginTransaction().disallowAddToBackStack()
            .add(containerViewId, fragment, tag)
            .commit()
}

