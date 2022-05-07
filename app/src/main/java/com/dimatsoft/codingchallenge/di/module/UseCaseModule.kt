package com.dimatsoft.codingchallenge.di.module

import com.dimatsoft.codingchallenge.domain.usecase.getHistoryItems.GetHistoryItemsUseCase
import com.dimatsoft.codingchallenge.domain.usecase.getHistoryItems.GetHistoryItemsUseCaseImpl
import com.dimatsoft.codingchallenge.domain.usecase.saveHistoryItem.SaveHistoryItemUseCase
import com.dimatsoft.codingchallenge.domain.usecase.saveHistoryItem.SaveHistoryItemUseCaseImpl
import com.dimatsoft.codingchallenge.domain.usecase.search.SearchPlaceUseCase
import com.dimatsoft.codingchallenge.domain.usecase.search.SearchPlaceUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    fun bindSearchPlaceUseCaseImpl(useCase: SearchPlaceUseCaseImpl): SearchPlaceUseCase

    @Binds
    fun bindGetHistoryItemsUseCase(useCase: GetHistoryItemsUseCaseImpl): GetHistoryItemsUseCase

    @Binds
    fun bindSaveHistoryItemUseCase(useCase: SaveHistoryItemUseCaseImpl): SaveHistoryItemUseCase
}
