package com.mario.github.mvp.ui.main.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import android.widget.SearchView
import com.jakewharton.rxbinding2.widget.RxSearchView
import com.mario.github.mvp.R
import com.mario.github.mvp.data.network.model.Repo
import com.mario.github.mvp.ui.base.view.BaseActivity
import com.mario.github.mvp.ui.main.MainAdapter
import com.mario.github.mvp.ui.main.interactor.MainMVPInteractor
import com.mario.github.mvp.ui.main.presenter.MainMVPPresenter
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
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
    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)

        val searchView = findViewById<SearchView>(R.id.searchView)

        initRxSearch(searchView)

        mainAdapter = MainAdapter { /* OnClickListener */ }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerViewResults.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        recyclerViewResults.setHasFixedSize(true)
        recyclerViewResults.adapter = mainAdapter
    }

    private fun initRxSearch(searchView: SearchView) {
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

    override fun showSearchResults(items: List<Repo>) {
        mainAdapter.setItems(items)
        showRecyclerView(true)
    }

    override fun showNoResultsLabel() {
        showRecyclerView(false)
    }

    fun showRecyclerView(show: Boolean) {
        if (show) {
            recyclerViewResults.visibility = View.VISIBLE
            textViewNoResults.visibility = View.GONE
        } else {
            recyclerViewResults.visibility = View.GONE
            textViewNoResults.visibility = View.VISIBLE
        }
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

}
