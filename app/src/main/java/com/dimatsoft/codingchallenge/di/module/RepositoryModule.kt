package com.dimatsoft.codingchallenge.di.module

import com.dimatsoft.codingchallenge.domain.repository.LocalRepository
import com.dimatsoft.codingchallenge.domain.repository.LocalRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindLocalRepository(repositoryImpl: LocalRepositoryImpl): LocalRepository
}