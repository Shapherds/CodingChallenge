package com.dimatsoft.codingchallenge.di.module

import com.dimatsoft.codingchallenge.domain.usecase.SearchPlaceUseCase
import com.dimatsoft.codingchallenge.domain.usecase.SearchPlaceUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    fun bindSearchPlaceUseCaseImpl(useCase: SearchPlaceUseCaseImpl): SearchPlaceUseCase
}
