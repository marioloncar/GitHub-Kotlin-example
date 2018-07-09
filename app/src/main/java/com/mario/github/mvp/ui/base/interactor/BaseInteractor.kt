package com.mario.github.mvp.ui.base.interactor

import com.mario.github.mvp.data.preferences.PreferenceHelper

/**
 * Created by mario on 09/07/18.
 */

open class BaseInteractor() : MVPInteractor {

    protected lateinit var preferenceHelper: PreferenceHelper

    constructor(preferenceHelper: PreferenceHelper) : this() {
        this.preferenceHelper = preferenceHelper
    }

}