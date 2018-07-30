package com.mario.github.mvp.ui.owner.interactor

import com.mario.github.mvp.data.preferences.PreferenceHelper
import com.mario.github.mvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class OwnerInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper) : BaseInteractor(preferenceHelper), OwnerMVPInteractor {
}