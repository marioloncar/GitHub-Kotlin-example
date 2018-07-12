package com.mario.github.mvp.ui.main.interactor

import com.mario.github.mvp.data.network.model.Repo
import com.mario.github.mvp.data.network.model.RepoResponse
import com.mario.github.mvp.data.network.remote.RepoService
import com.mario.github.mvp.data.preferences.PreferenceHelper
import com.mario.github.mvp.ui.base.interactor.BaseInteractor
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by mario on 09/07/18.
 */

class MainInteractor @Inject internal constructor(private val repoService: RepoService, preferenceHelper: PreferenceHelper) : BaseInteractor(preferenceHelper = preferenceHelper), MainMVPInteractor {
    override fun getSearchResults(keyword: String): Observable<List<Repo>>? = repoService.searchRepositories(keyword, preferenceHelper.getSortType()).map(RepoResponse::repos)
}