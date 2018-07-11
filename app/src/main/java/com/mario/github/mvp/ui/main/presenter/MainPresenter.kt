package com.mario.github.mvp.ui.main.presenter

import com.mario.github.mvp.ui.base.presenter.BasePresenter
import com.mario.github.mvp.ui.main.interactor.MainMVPInteractor
import com.mario.github.mvp.ui.main.view.MainMVPView
import com.mario.github.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by mario on 09/07/18.
 */

class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), MainMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
    }

    override fun searchRepositories(keyword: String) {
        interactor
                ?.getSearchResults(keyword)
                ?.compose(schedulerProvider.ioToMainObservableScheduler())
                ?.subscribe { t -> getView()?.showSearchResults(t) }
    }
}