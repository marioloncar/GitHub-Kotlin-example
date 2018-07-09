package com.mario.github.mvp.ui.base.presenter

import com.mario.github.mvp.ui.base.interactor.MVPInteractor
import com.mario.github.mvp.ui.base.view.MVPView

/**
 * Created by mario on 09/07/18.
 */

interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}