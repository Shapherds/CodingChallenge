package com.dimatsoft.codingchallenge.data.mapper

import com.dimatsoft.codingchallenge.data.model.SearchModelResponse
import com.dimatsoft.codingchallenge.domain.model.SearchResult
import javax.inject.Inject

class SearchModelResponseToSearchResultMapper @Inject constructor() :
        (SearchModelResponse) -> SearchResult {

    override fun invoke(response: SearchModelResponse): SearchResult {
        return SearchResult(
            id = response.id,
            secret = response.secret,
            server = response.server,
            farm = response.farm
        )
    }
}