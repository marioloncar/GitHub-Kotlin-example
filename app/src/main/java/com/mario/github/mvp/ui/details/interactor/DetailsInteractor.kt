package com.mario.github.mvp.ui.details.interactor

import com.mario.github.mvp.data.network.remote.RepoService
import com.mario.github.mvp.data.preferences.PreferenceHelper
import com.mario.github.mvp.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class DetailsInteractor @Inject internal constructor(private val repoService: RepoService, preferenceHelper: PreferenceHelper): BaseInteractor(preferenceHelper), DetailsMVPInteractor {
}