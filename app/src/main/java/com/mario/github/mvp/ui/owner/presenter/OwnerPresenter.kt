package com.mario.github.mvp.ui.owner.presenter

import com.mario.github.mvp.data.network.model.Owner
import com.mario.github.mvp.ui.base.presenter.BasePresenter
import com.mario.github.mvp.ui.owner.interactor.OwnerMVPInteractor
import com.mario.github.mvp.ui.owner.view.OwnerMVPView
import com.mario.github.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class OwnerPresenter<V : OwnerMVPView, I : OwnerMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor, schedulerProvider, compositeDisposable), OwnerMVPPresenter<V, I> {

    var owner: Owner? = null

    override fun onAttach(view: V?) {
        super.onAttach(view)
        owner = getView()?.getOwnerExtra()

        owner?.let { getView()?.showOwnerData(it) }
    }

    override fun onOpenInBrowserClicked() {
        owner?.htmlUrl?.let { getView()?.showOwnerDetailsInBrowser(it) }

    }
}