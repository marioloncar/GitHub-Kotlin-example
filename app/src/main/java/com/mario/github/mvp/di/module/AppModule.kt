package com.mario.github.mvp.di.module

import android.app.Application
import android.content.Context
import com.mario.github.mvp.data.preferences.AppPreferenceHelper
import com.mario.github.mvp.data.preferences.PreferenceHelper
import com.mario.github.mvp.di.PreferenceInfo
import com.mario.github.mvp.util.AppConstants
import com.mario.github.mvp.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by mario on 09/07/18.
 */

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    /*
        @Provides
        @ApiKeyInfo
        internal fun provideApiKey(): String = BuildConfig.API_KEY
    */

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()


}