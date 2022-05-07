package com.dimatsoft.codingchallenge.domain.usecase.search

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface SearchPlaceUseCase {

    suspend operator fun invoke(searchText: String): Flow<PagingData<String>>
}