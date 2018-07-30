package com.mario.github.mvp.ui.details.presenter

import com.mario.github.mvp.ui.base.presenter.MVPPresenter
import com.mario.github.mvp.ui.details.interactor.DetailsMVPInteractor
import com.mario.github.mvp.ui.details.view.DetailsMVPView

interface DetailsMVPPresenter<V : DetailsMVPView, I : DetailsMVPInteractor> : MVPPresenter<V, I> {
    fun onShowOwnerDetailsClicked()
    fun onOpenInBrowserClicked()
}