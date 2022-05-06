package com.dimatsoft.codingchallenge.base

import com.dimatsoft.codingchallenge.di.DaggerDaggerComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val daggerComponent = DaggerDaggerComponent.builder().context(this).build()
        daggerComponent.inject(this)
        return daggerComponent
    }
}