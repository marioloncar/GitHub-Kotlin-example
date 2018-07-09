package com.mario.github.mvp.data.preferences

import com.mario.github.mvp.util.AppConstants

/**
 * Created by mario on 09/07/18.
 */

interface PreferenceHelper {

    fun getCurrentUserLoggedInMode(): Int

    fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode)

    fun getCurrentUserName(): String

    fun setCurrentUserName(userName: String?)

    fun getCurrentUserEmail(): String?

    fun setCurrentUserEmail(email: String?)

    fun getAccessToken(): String?

    fun setAccessToken(accessToken: String?)

}