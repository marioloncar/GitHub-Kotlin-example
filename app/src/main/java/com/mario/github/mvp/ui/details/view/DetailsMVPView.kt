package com.mario.github.mvp.ui.details.view

import com.mario.github.mvp.data.network.model.Owner
import com.mario.github.mvp.data.network.model.Repo
import com.mario.github.mvp.ui.base.view.MVPView

interface DetailsMVPView : MVPView {
    fun getRepoExtra(): Repo?
    fun showRepoDetails(repo: Repo)
    fun showRepoDetailsInBrowser(url: String)
    fun showOwnerDetails(owner: Owner)
}