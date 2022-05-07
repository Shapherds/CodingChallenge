package com.dimatsoft.codingchallenge.data.mapper

import com.dimatsoft.codingchallenge.data.model.PhotoResponse
import javax.inject.Inject

class SearchModelResponseToSearchResultMapper @Inject constructor() :
        (PhotoResponse) -> String {

    override fun invoke(response: PhotoResponse): String {
        return createUrl(response)
    }

    private fun createUrl(searchResult: PhotoResponse): String =
        "https://farm${searchResult.farm}.static.flickr.com/${searchResult.server}/${searchResult.id}_${searchResult.secret}.jpg"
}