package com.mario.github.mvp.ui.owner

import com.mario.github.mvp.ui.owner.interactor.OwnerInteractor
import com.mario.github.mvp.ui.owner.interactor.OwnerMVPInteractor
import com.mario.github.mvp.ui.owner.presenter.OwnerMVPPresenter
import com.mario.github.mvp.ui.owner.presenter.OwnerPresenter
import com.mario.github.mvp.ui.owner.view.OwnerMVPView
import dagger.Module
import dagger.Provides

@Module
class OwnerActivityModule {

    @Provides
    internal fun provideOwnerInteractor(interactor: OwnerInteractor): OwnerMVPInteractor = interactor

    @Provides
    internal fun provideOwnerPresenter(presenter: OwnerPresenter<OwnerMVPView, OwnerMVPInteractor>)
            : OwnerMVPPresenter<OwnerMVPView, OwnerMVPInteractor> = presenter
}