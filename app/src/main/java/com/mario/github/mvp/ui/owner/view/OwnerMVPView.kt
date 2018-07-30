package com.mario.github.mvp.ui.owner.view

import com.mario.github.mvp.data.network.model.Owner
import com.mario.github.mvp.ui.base.view.MVPView

interface OwnerMVPView : MVPView {
    fun showOwnerData(owner: Owner)
    fun getOwnerExtra(): Owner?
    fun showOwnerDetailsInBrowser(url: String)
}