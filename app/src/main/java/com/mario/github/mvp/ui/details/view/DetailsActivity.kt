package com.mario.github.mvp.ui.details.view

import android.os.Bundle
import android.support.v4.app.Fragment
import com.mario.github.mvp.R
import com.mario.github.mvp.data.network.model.Repo
import com.mario.github.mvp.ui.base.view.BaseActivity
import com.mario.github.mvp.ui.details.interactor.DetailsMVPInteractor
import com.mario.github.mvp.ui.details.presenter.DetailsMVPPresenter
import com.mario.github.mvp.ui.main.view.MainActivity.Companion.REPO_PARCELABLE_KEY
import com.mario.github.mvp.util.CommonUtil
import com.mario.github.mvp.util.extension.getParcel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_repo_details.*
import javax.inject.Inject

class DetailsActivity : BaseActivity(), DetailsMVPView, HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    internal lateinit var presenter: DetailsMVPPresenter<DetailsMVPView, DetailsMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_details)
        presenter.onAttach(this)

    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    override fun getRepoExtra(): Repo? {
        return intent.getParcel(REPO_PARCELABLE_KEY)
    }

    override fun showRepoDetails(repo: Repo) {
        textview_repo_full_name.text = repo.fullName
        textview_repo_description.text = repo.description
        textview_repo_language.text = repo.language
        textview_repo_created.text = repo.createdAt?.let { CommonUtil.convertDate(it) }
        textview_repo_last_update.text = repo.updatedAt?.let { CommonUtil.convertDate(it) }
        textview_repo_forks.text = repo.forksCount.toString()
        textview_repo_issues.text = repo.openIssuesCount.toString()
        textview_repo_watchers.text = repo.watchersCount.toString()

        if (repo.fork) {
            imageview_repo_fork.setImageResource(R.drawable.ic_true)
        } else {
            imageview_repo_fork.setImageResource(R.drawable.ic_false)
        }

        if (repo.archived) {
            imageview_repo_archived.setImageResource(R.drawable.ic_true)
        } else {
            imageview_repo_archived.setImageResource(R.drawable.ic_false)
        }

        if (repo.privateRepo) {
            imageview_repo_private.setImageResource(R.drawable.ic_true)
        } else {
            imageview_repo_private.setImageResource(R.drawable.ic_false)
        }

    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}