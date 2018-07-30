package com.mario.github.mvp.ui.owner.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import com.mario.github.mvp.R
import com.mario.github.mvp.data.network.model.Owner
import com.mario.github.mvp.ui.base.view.BaseActivity
import com.mario.github.mvp.ui.details.view.DetailsActivity.Companion.OWNER_PARCELABLE_KEY
import com.mario.github.mvp.ui.owner.interactor.OwnerMVPInteractor
import com.mario.github.mvp.ui.owner.presenter.OwnerMVPPresenter
import com.mario.github.mvp.util.extension.getParcel
import com.mario.github.mvp.util.extension.loadImage
import kotlinx.android.synthetic.main.activity_owner_details.*
import kotlinx.android.synthetic.main.layout_owner_details.*
import javax.inject.Inject

class OwnerActivity : BaseActivity(), OwnerMVPView, View.OnClickListener {

    @Inject
    internal lateinit var presenter: OwnerMVPPresenter<OwnerMVPView, OwnerMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_owner_details)
        presenter.onAttach(this)
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun getOwnerExtra(): Owner? = intent.getParcel(OWNER_PARCELABLE_KEY)

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun showOwnerData(owner: Owner) {
        textview_owner_name.text = owner.login
        textview_owner_type.text = owner.type

        if (owner.siteAdmin) {
            imageview_owner_site_admin.setImageResource(R.drawable.ic_true)
        } else {
            imageview_owner_site_admin.setImageResource(R.drawable.ic_false)
        }

        owner.avatarUrl?.let { imageview_owner_avatar.loadImage(it) }
    }

    override fun showOwnerDetailsInBrowser(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab_owner_open_in_web -> presenter.onOpenInBrowserClicked()
        }
    }
}