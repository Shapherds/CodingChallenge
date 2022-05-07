package com.dimatsoft.codingchallenge.domain.repository

import com.dimatsoft.codingchallenge.data.api.FlickrApi
import com.dimatsoft.codingchallenge.data.mapper.SearchModelResponseToSearchResultMapper
import com.dimatsoft.codingchallenge.domain.model.SearchResult
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val flickrApi: FlickrApi,
    private val searchModelResponseToSearchResultMapper: SearchModelResponseToSearchResultMapper
) : LocalRepository {

    override suspend fun getFlickObjects(searchText: String, page: Int): List<SearchResult> {
        return flickrApi.getImages(searchText, page).photos.photo.map(
            searchModelResponseToSearchResultMapper
        )
    }
}