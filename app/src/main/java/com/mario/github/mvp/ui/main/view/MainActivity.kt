package com.mario.github.mvp.ui.main.view

import android.os.Bundle
import android.widget.SearchView
import com.jakewharton.rxbinding2.widget.RxSearchView
import com.mario.github.mvp.R
import com.mario.github.mvp.data.network.model.Repo
import com.mario.github.mvp.ui.base.view.BaseActivity
import com.mario.github.mvp.ui.main.interactor.MainMVPInteractor
import com.mario.github.mvp.ui.main.presenter.MainMVPPresenter
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by mario on 09/07/18.
 */

class MainActivity : BaseActivity(), MainMVPView {

    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>

    lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)

        val searchView = findViewById<SearchView>(R.id.searchView)

        RxSearchView.queryTextChanges(searchView)
                .debounce(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<CharSequence> {
                    override fun onSubscribe(d: Disposable) {
                        disposable = d
                    }

                    override fun onNext(charSequence: CharSequence) {
                        if (charSequence.isNotEmpty()) {
                            presenter.searchRepositories(charSequence.toString())
                        }
                    }

                    override fun onError(e: Throwable) {
                        Timber.i(e.message, "onError: ")
                    }

                    override fun onComplete() {
                        Timber.i("onComplete: ")

                    }
                })
    }

    override fun onDestroy() {
        presenter.onDetach()
        disposable.dispose()
        super.onDestroy()
    }

    override fun showSearchResults(items: List<Repo>?) {
        print("RESULTS $items")
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

}
