package com.mario.github.mvp.ui.main.interactor

import com.mario.github.mvp.data.network.model.Repo
import com.mario.github.mvp.data.network.model.RepoResponse
import com.mario.github.mvp.ui.base.interactor.MVPInteractor
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by mario on 09/07/18.
 */

interface MainMVPInteractor : MVPInteractor {
    fun getSearchResults(keyword: String): Observable<List<Repo>>?
}