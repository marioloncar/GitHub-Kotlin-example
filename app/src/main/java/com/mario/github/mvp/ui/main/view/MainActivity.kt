package com.mario.github.mvp.ui.main.view

import android.os.Bundle
import com.mario.github.mvp.R
import com.mario.github.mvp.ui.base.view.BaseActivity
import com.mario.github.mvp.ui.main.interactor.MainMVPInteractor
import com.mario.github.mvp.ui.main.presenter.MainMVPPresenter
import com.mario.github.mvp.util.extension.removeFragment
import javax.inject.Inject

/**
 * Created by mario on 09/07/18.
 */

class MainActivity : BaseActivity(), MainMVPView {

    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentDetached(tag: String) {
        supportFragmentManager?.removeFragment(tag = tag)
    }

    override fun onFragmentAttached() {
    }

}
