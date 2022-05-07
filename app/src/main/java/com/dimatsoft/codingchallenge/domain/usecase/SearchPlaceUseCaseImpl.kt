package com.dimatsoft.codingchallenge.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dimatsoft.codingchallenge.data.source.PhotoSource
import com.dimatsoft.codingchallenge.domain.model.SearchResult
import com.dimatsoft.codingchallenge.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchPlaceUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
) : SearchPlaceUseCase {

    override suspend operator fun invoke(searchText: String): Flow<PagingData<SearchResult>> =
        Pager(
            config = PagingConfig(6),
            pagingSourceFactory = {
                PhotoSource(localRepository, searchText)
            }
        ).flow

}