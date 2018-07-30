package com.mario.github.mvp.ui.owner.presenter

import com.mario.github.mvp.ui.base.presenter.MVPPresenter
import com.mario.github.mvp.ui.owner.interactor.OwnerMVPInteractor
import com.mario.github.mvp.ui.owner.view.OwnerMVPView

interface OwnerMVPPresenter<V : OwnerMVPView, I : OwnerMVPInteractor> : MVPPresenter<V, I> {
    fun onOpenInBrowserClicked()
}