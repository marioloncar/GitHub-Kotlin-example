package com.mario.github.mvp.di.builder

import com.mario.github.mvp.ui.details.DetailsActivityModule
import com.mario.github.mvp.ui.details.view.DetailsActivity
import com.mario.github.mvp.ui.main.MainActivityModule
import com.mario.github.mvp.ui.main.view.MainActivity
import com.mario.github.mvp.ui.owner.OwnerActivityModule
import com.mario.github.mvp.ui.owner.view.OwnerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mario on 09/07/18.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(DetailsActivityModule::class)])
    abstract fun bindDetailsActivity(): DetailsActivity

    @ContributesAndroidInjector(modules = [(OwnerActivityModule::class)])
    abstract fun bindOwnerActivity(): OwnerActivity

}