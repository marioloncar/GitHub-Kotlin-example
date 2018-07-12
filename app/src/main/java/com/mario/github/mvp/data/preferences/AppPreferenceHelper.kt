package com.mario.github.mvp.data.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.mario.github.mvp.di.PreferenceInfo
import com.mario.github.mvp.util.AppConstants
import javax.inject.Inject

/**
 * Created by mario on 09/07/18.
 */
class AppPreferenceHelper @Inject constructor(context: Context,
                                              @PreferenceInfo private val prefFileName: String) : PreferenceHelper {
    companion object {
        private val PREF_KEY_APP = "PREF_KEY_APP"
        private val PREF_KEY_SORT_TYPE = "PREF_KEY_SORT_TYPE"
        private val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        private val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getCurrentUserLoggedInMode() = prefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE, AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type)

    override fun getCurrentUserName(): String = prefs.getString(PREF_KEY_CURRENT_USER_NAME, "ABC")

    override fun setCurrentUserName(userName: String?) = prefs.edit { putString(PREF_KEY_CURRENT_USER_NAME, userName) }

    override fun getCurrentUserEmail(): String = prefs.getString(PREF_KEY_CURRENT_USER_EMAIL, "abc@gmail.com")

    override fun setCurrentUserEmail(email: String?) = prefs.edit { putString(PREF_KEY_CURRENT_USER_EMAIL, email) }

    override fun getAccessToken(): String = prefs.getString(PREF_KEY_ACCESS_TOKEN, "")

    override fun setAccessToken(accessToken: String?) = prefs.edit { putString(PREF_KEY_ACCESS_TOKEN, accessToken) }

    override fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode) {
        prefs.edit { putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.type) }
    }

    override fun setSortType(sortType: String?) = prefs.edit { putString(PREF_KEY_SORT_TYPE, sortType) }

    override fun getSortType(): String = prefs.getString(PREF_KEY_SORT_TYPE, "")

}