package com.mario.github.mvp.ui.main.presenter

import com.mario.github.mvp.data.network.model.Repo
import com.mario.github.mvp.data.preferences.PreferenceHelper
import com.mario.github.mvp.ui.base.presenter.BasePresenter
import com.mario.github.mvp.ui.main.interactor.MainMVPInteractor
import com.mario.github.mvp.ui.main.view.MainMVPView
import com.mario.github.mvp.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.util.*
import javax.inject.Inject

/**
 * Created by mario on 09/07/18.
 */

class MainPresenter<V : MainMVPView, I : MainMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable, preferenceHelper: PreferenceHelper) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), MainMVPPresenter<V, I> {

    private var itemList: MutableList<Repo> = ArrayList()

    override fun onAttach(view: V?) {
        super.onAttach(view)
    }

    override fun searchRepositories(keyword: String) {
        interactor
                ?.getSearchResults(keyword)
                ?.compose(schedulerProvider.ioToMainObservableScheduler())
                ?.subscribe { t ->
                    if (t.isEmpty()) {
                        getView()?.showNoResultsLabel()
                    } else {
                        itemList.clear()
                        itemList.addAll(t)
                        getView()?.showSearchResults(itemList)
                    }
                }
    }

    override fun onSortTypeOptionSelected(sortType: String?) {
        interactor?.getPreferenceHelper()?.setSortType(sortType)
    }

    override fun onRepoClicked(position: Int) {
        getView()?.openRepoDetails(itemList[position])
    }


}