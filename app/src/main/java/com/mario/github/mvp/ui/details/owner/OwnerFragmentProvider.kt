package com.mario.github.mvp.ui.details.owner

import com.mario.github.mvp.ui.details.owner.view.OwnerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class OwnerFragmentProvider {
    @ContributesAndroidInjector(modules = [OwnerFragmentModule::class])
    internal abstract fun provideOwnerFragmentFactory(): OwnerFragment
}