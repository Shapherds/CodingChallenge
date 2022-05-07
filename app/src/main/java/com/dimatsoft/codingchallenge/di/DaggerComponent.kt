package com.dimatsoft.codingchallenge.di

import android.content.Context
import com.dimatsoft.codingchallenge.base.App
import com.dimatsoft.codingchallenge.di.module.DatabaseModule
import com.dimatsoft.codingchallenge.di.module.FragmentModule
import com.dimatsoft.codingchallenge.di.module.NetworkModule
import com.dimatsoft.codingchallenge.di.module.ProviderModule
import com.dimatsoft.codingchallenge.di.module.RepositoryModule
import com.dimatsoft.codingchallenge.di.module.UseCaseModule
import com.dimatsoft.codingchallenge.di.module.ViewModelModule
import com.dimatsoft.codingchallenge.di.viewModelSetup.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        FragmentModule::class,
        ViewModelModule::class,
        DatabaseModule::class,
        ProviderModule::class,
        AndroidInjectionModule::class
    ]
)
interface DaggerComponent : AndroidInjector<DaggerApplication> {

    fun inject(instance: App)

    @Component.Builder
    interface ComponentBuilder {

        @BindsInstance
        fun context(context: Context): ComponentBuilder

        fun build(): DaggerComponent
    }
}