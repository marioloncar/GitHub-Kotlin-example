package com.mario.github.mvp.ui.details.owner.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mario.github.mvp.R
import com.mario.github.mvp.ui.base.view.BaseFragment
import com.mario.github.mvp.ui.details.owner.interactor.OwnerMVPInteractor
import com.mario.github.mvp.ui.details.owner.presenter.OwnerMVPPresenter
import javax.inject.Inject

class OwnerFragment : BaseFragment(), OwnerMVPView {

    companion object {
        fun newInstance() : OwnerFragment = OwnerFragment()
    }

    @Inject
    internal lateinit var presenter: OwnerMVPPresenter<OwnerMVPView, OwnerMVPInteractor>

    override fun setUp() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_owner_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }
}