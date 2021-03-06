package com.dimatsoft.codingchallenge.domain.repository

import com.dimatsoft.codingchallenge.data.api.FlickrApi
import com.dimatsoft.codingchallenge.data.mapper.SearchModelResponseToSearchResultMapper
import com.dimatsoft.codingchallenge.data.model.SearchModelRequest
import com.dimatsoft.codingchallenge.domain.model.SearchResult
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val flickrApi: FlickrApi,
    private val searchModelResponseToSearchResultMapper: SearchModelResponseToSearchResultMapper
) : LocalRepository {

    override suspend fun getFlickObjects(searchText: String): List<SearchResult> =
        flickrApi.getImages(
            SearchModelRequest(
                method = "flickr.photos.search",
                api_key = "37ad288835e4c64fc0cb8af3f3a1a65d",
                format = "format",
                nojsoncallback = 1,
                safe_search = 1,
                text = searchText
            )
        ).map(searchModelResponseToSearchResultMapper)
}