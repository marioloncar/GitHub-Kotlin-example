package com.mario.github.mvp.ui.details.presenter

import com.mario.github.mvp.data.network.model.Repo
import com.mario.github.mvp.data.preferences.PreferenceHelper
import com.mario.github.mvp.ui.base.presenter.BasePresenter
import com.mario.github.mvp.ui.details.interactor.DetailsMVPInteractor
import com.mario.github.mvp.ui.details.view.DetailsMVPView
import com.mario.github.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailsPresenter<V : DetailsMVPView, I : DetailsMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable, preferenceHelper: PreferenceHelper) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), DetailsMVPPresenter<V, I> {

    private var repo: Repo? = null

    override fun onAttach(view: V?) {
        super.onAttach(view)
        repo = getView()?.getRepoExtra()

        repo?.let { getView()?.showRepoDetails(it) }
    }

    override fun onShowOwnerDetailsClicked() {
        repo?.owner?.let { getView()?.showOwnerDetails(it) }
    }

    override fun onOpenInBrowserClicked() {
        repo?.htmlUrl?.let { getView()?.showRepoDetailsInBrowser(it) }
    }

}