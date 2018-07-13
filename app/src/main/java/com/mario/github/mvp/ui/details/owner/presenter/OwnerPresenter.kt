package com.mario.github.mvp.ui.details.owner.presenter

import com.mario.github.mvp.ui.base.presenter.BasePresenter
import com.mario.github.mvp.ui.details.owner.interactor.OwnerMVPInteractor
import com.mario.github.mvp.ui.details.owner.view.OwnerMVPView
import com.mario.github.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class OwnerPresenter<V : OwnerMVPView, I : OwnerMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor, schedulerProvider, compositeDisposable), OwnerMVPPresenter<V, I> {
}