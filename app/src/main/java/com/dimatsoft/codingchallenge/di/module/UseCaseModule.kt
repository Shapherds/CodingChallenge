package com.dimatsoft.codingchallenge.di.module

import com.dimatsoft.codingchallenge.domain.usecase.getHistoryItems.GetSearchHistoryUseCase
import com.dimatsoft.codingchallenge.domain.usecase.getHistoryItems.GetSearchHistoryUseCaseImpl
import com.dimatsoft.codingchallenge.domain.usecase.saveHistoryItem.SaveSearchHistoryUseCase
import com.dimatsoft.codingchallenge.domain.usecase.saveHistoryItem.SaveSearchHistoryUseCaseImpl
import com.dimatsoft.codingchallenge.domain.usecase.search.SearchPlaceUseCase
import com.dimatsoft.codingchallenge.domain.usecase.search.SearchPlaceUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    fun bindSearchPlaceUseCaseImpl(useCase: SearchPlaceUseCaseImpl): SearchPlaceUseCase

    @Binds
    fun bindGetHistoryItemsUseCase(useCase: GetSearchHistoryUseCaseImpl): GetSearchHistoryUseCase

    @Binds
    fun bindSaveHistoryItemUseCase(useCase: SaveSearchHistoryUseCaseImpl): SaveSearchHistoryUseCase
}
