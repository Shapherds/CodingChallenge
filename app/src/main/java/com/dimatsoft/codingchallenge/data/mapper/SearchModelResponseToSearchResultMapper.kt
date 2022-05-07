package com.dimatsoft.codingchallenge.data.mapper

import com.dimatsoft.codingchallenge.data.model.PhotoResponse
import com.dimatsoft.codingchallenge.domain.model.SearchResult
import javax.inject.Inject

class SearchModelResponseToSearchResultMapper @Inject constructor() :
        (PhotoResponse) -> SearchResult {

    override fun invoke(response: PhotoResponse): SearchResult {
        return SearchResult(
            id = response.id,
            secret = response.secret,
            server = response.server,
            farm = response.farm
        )
    }
}