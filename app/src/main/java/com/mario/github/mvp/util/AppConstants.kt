package com.mario.github.mvp.util


/**
 * Created by mario on 09/07/18.
 */

object AppConstants {

    internal val PREF_NAME = "github_example_pref"

    enum class LoggedInMode constructor(val type: Int) {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3)
    }
}