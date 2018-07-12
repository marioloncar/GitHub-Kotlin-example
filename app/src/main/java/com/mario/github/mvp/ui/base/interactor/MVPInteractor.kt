package com.mario.github.mvp.ui.base.interactor

import com.mario.github.mvp.data.preferences.PreferenceHelper

/**
 * Created by mario on 09/07/18.
 */

interface MVPInteractor {
/* We will need this later

    fun isUserLoggedIn(): Boolean

    fun performUserLogout()
    */

    fun getPreferenceHelper(): PreferenceHelper
}