package com.dimatsoft.codingchallenge.domain.usecase

import com.dimatsoft.codingchallenge.domain.model.SearchResult
import com.dimatsoft.codingchallenge.domain.repository.LocalRepository
import javax.inject.Inject

class SearchPlaceUseCaseImpl @Inject constructor(
    private val localRepository: LocalRepository
) : SearchPlaceUseCase {

    override suspend operator fun invoke(searchText: String): List<SearchResult> =
        localRepository.getFlickObjects(searchText)

}