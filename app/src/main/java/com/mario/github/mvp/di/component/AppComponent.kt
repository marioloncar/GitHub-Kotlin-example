package com.mario.github.mvp.di.component

import android.app.Application
import com.mario.github.mvp.MvpApp
import com.mario.github.mvp.di.builder.ActivityBuilder
import com.mario.github.mvp.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by mario on 09/07/18.
 */

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MvpApp)

}