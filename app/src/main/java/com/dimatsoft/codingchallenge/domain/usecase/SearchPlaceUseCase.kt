package com.dimatsoft.codingchallenge.domain.usecase

import com.dimatsoft.codingchallenge.domain.model.SearchResult

interface SearchPlaceUseCase {

    suspend operator fun invoke(searchText: String): List<SearchResult>
}