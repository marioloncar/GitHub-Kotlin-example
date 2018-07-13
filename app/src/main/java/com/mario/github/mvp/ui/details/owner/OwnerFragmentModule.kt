package com.mario.github.mvp.ui.details.owner

import com.mario.github.mvp.ui.details.owner.interactor.OwnerInteractor
import com.mario.github.mvp.ui.details.owner.interactor.OwnerMVPInteractor
import com.mario.github.mvp.ui.details.owner.presenter.OwnerMVPPresenter
import com.mario.github.mvp.ui.details.owner.presenter.OwnerPresenter
import com.mario.github.mvp.ui.details.owner.view.OwnerMVPView
import dagger.Module
import dagger.Provides

@Module
class OwnerFragmentModule {
    @Provides
    internal fun provideOwnerInteractor(interactor: OwnerInteractor): OwnerMVPInteractor = interactor

    @Provides
    internal fun provideOwnerPresenter(presenter: OwnerPresenter<OwnerMVPView, OwnerMVPInteractor>) : OwnerMVPPresenter<OwnerMVPView, OwnerMVPInteractor> = presenter
}