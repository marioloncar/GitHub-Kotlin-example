package com.mario.github.mvp.ui.main.view

import com.mario.github.mvp.data.network.model.Repo
import com.mario.github.mvp.ui.base.view.MVPView

/**
 * Created by mario on 09/07/18.
 */

interface MainMVPView : MVPView {
    fun showSearchResults(items: List<Repo>?)
}