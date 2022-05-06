package com.dimatsoft.codingchallenge.di.module

import com.dimatsoft.codingchallenge.presentation.ui.fragment.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun bindSearchFragment(): SearchFragment
}