package com.mario.github.mvp.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding2.widget.RxSearchView
import com.mario.github.mvp.R
import com.mario.github.mvp.data.network.model.Repo
import com.mario.github.mvp.ui.base.view.BaseActivity
import com.mario.github.mvp.ui.details.view.DetailsActivity
import com.mario.github.mvp.ui.main.MainAdapter
import com.mario.github.mvp.ui.main.interactor.MainMVPInteractor
import com.mario.github.mvp.ui.main.presenter.MainMVPPresenter
import com.mario.github.mvp.util.extension.OnItemClickListener
import com.mario.github.mvp.util.extension.addOnItemClickListener
import com.mario.github.mvp.util.extension.putParcel
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

class MainActivity : BaseActivity(), MainMVPView, AdapterView.OnItemSelectedListener {

    companion object {
        const val REPO_PARCELABLE_KEY = "REPO_PARCELABLE_KEY"
    }

    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>

    @Inject
    internal lateinit var mainAdapter: MainAdapter

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onAttach(this)

        val searchView: SearchView = findViewById(R.id.searchview)

        spinner_sort_types.onItemSelectedListener = this
        prepareSearchView(searchView)
        prepareRecyclerView()

    }

    private fun prepareRecyclerView() {
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerview_results.layoutManager = layoutManager
        recyclerview_results.setHasFixedSize(true)
        recyclerview_results.adapter = mainAdapter

        recyclerview_results.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                presenter.onRepoClicked(position)
            }
        })
    }

    private fun prepareSearchView(searchView: SearchView) {
        RxSearchView.queryTextChanges(searchView)
                .debounce(400, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .filter { text -> text.isNotBlank() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<CharSequence> {
                    override fun onSubscribe(d: Disposable) {
                        disposable = d
                    }

                    override fun onNext(charSequence: CharSequence) {
                        presenter.searchRepositories(charSequence.toString())
                    }

                    override fun onError(e: Throwable) {
                        Timber.i(e.message, "onError: ")
                    }

                    override fun onComplete() {
                        Timber.i("onComplete: ")

                    }
                })
    }

    fun showRecyclerView(show: Boolean) {
        if (show) {
            recyclerview_results.visibility = View.VISIBLE
            textview_no_results.visibility = View.GONE
        } else {
            recyclerview_results.visibility = View.GONE
            textview_no_results.visibility = View.VISIBLE
        }
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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val sortType = parent?.getItemAtPosition(position).toString()
        presenter.onSortTypeOptionSelected(sortType)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        presenter.onSortTypeOptionSelected(null)
    }

    override fun openRepoDetails(repo: Repo) {
        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
        intent.putParcel(REPO_PARCELABLE_KEY, repo)
        startActivity(intent)
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

}
