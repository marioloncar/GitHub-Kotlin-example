package com.mario.github.mvp.ui.main.interactor

import com.mario.github.mvp.data.network.model.Repo
import com.mario.github.mvp.data.network.model.RepoResponse
import com.mario.github.mvp.data.network.remote.RepoService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by mario on 09/07/18.
 */

class MainInteractor @Inject internal constructor(private val repoService: RepoService) : MainMVPInteractor {
    override fun getSearchResults(keyword: String): Observable<List<Repo>>? = repoService.searchRepositories(keyword).map(RepoResponse::repos)
}


