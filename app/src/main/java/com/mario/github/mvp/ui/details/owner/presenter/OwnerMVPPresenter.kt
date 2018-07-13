package com.mario.github.mvp.ui.details.owner.presenter

import com.mario.github.mvp.ui.base.presenter.MVPPresenter
import com.mario.github.mvp.ui.details.owner.interactor.OwnerMVPInteractor
import com.mario.github.mvp.ui.details.owner.view.OwnerMVPView

interface OwnerMVPPresenter<V : OwnerMVPView, I : OwnerMVPInteractor> : MVPPresenter<V, I> {
}