package com.mario.github.mvp.di.builder

import com.mario.github.mvp.ui.main.MainActivityModule
import com.mario.github.mvp.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by mario on 09/07/18.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

}