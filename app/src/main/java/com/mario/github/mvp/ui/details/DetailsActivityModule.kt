package com.mario.github.mvp.ui.details

import com.mario.github.mvp.ui.details.interactor.DetailsInteractor
import com.mario.github.mvp.ui.details.interactor.DetailsMVPInteractor
import com.mario.github.mvp.ui.details.presenter.DetailsMVPPresenter
import com.mario.github.mvp.ui.details.presenter.DetailsPresenter
import com.mario.github.mvp.ui.details.view.DetailsMVPView
import dagger.Module
import dagger.Provides

@Module
class DetailsActivityModule {

    @Provides
    internal fun provideDetailsInteractor(detailsInteractor: DetailsInteractor): DetailsMVPInteractor = detailsInteractor

    @Provides
    internal fun provideDetailsPresenter(detailsPresenter: DetailsPresenter<DetailsMVPView, DetailsMVPInteractor>)
            : DetailsMVPPresenter<DetailsMVPView, DetailsMVPInteractor> = detailsPresenter

}