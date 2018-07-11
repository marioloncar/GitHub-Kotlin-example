package com.mario.github.mvp.ui.main.presenter

import com.mario.github.mvp.ui.base.presenter.MVPPresenter
import com.mario.github.mvp.ui.main.interactor.MainMVPInteractor
import com.mario.github.mvp.ui.main.view.MainMVPView

/**
 * Created by mario on 09/07/18.
 */

interface MainMVPPresenter<V : MainMVPView, I : MainMVPInteractor> : MVPPresenter<V, I> {
    fun searchRepositories(keyword: String)
}