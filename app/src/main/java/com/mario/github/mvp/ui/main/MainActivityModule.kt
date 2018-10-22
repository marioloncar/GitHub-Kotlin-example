package com.mario.github.mvp.ui.main

import androidx.recyclerview.widget.LinearLayoutManager
import com.mario.github.mvp.ui.main.interactor.MainInteractor
import com.mario.github.mvp.ui.main.interactor.MainMVPInteractor
import com.mario.github.mvp.ui.main.presenter.MainMVPPresenter
import com.mario.github.mvp.ui.main.presenter.MainPresenter
import com.mario.github.mvp.ui.main.view.MainActivity
import com.mario.github.mvp.ui.main.view.MainMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by mario on 09/07/18.
 */

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMVPInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMVPView, MainMVPInteractor>)
            : MainMVPPresenter<MainMVPView, MainMVPInteractor> = mainPresenter

    @Provides
    internal fun provideMainAdapter(): MainAdapter = MainAdapter()

    @Provides
    internal fun provideLinearLayoutManager(activity: MainActivity): LinearLayoutManager = LinearLayoutManager(activity)

}