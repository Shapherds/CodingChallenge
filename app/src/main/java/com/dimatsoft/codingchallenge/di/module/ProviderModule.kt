package com.dimatsoft.codingchallenge.di.module

import com.dimatsoft.codingchallenge.data.database.DataBaseProvider
import com.dimatsoft.codingchallenge.data.database.DataBaseProviderImpl
import dagger.Binds
import dagger.Module


@Module
interface ProviderModule {

    @Binds
    fun bindDataBaseProvider(provider: DataBaseProviderImpl): DataBaseProvider
}