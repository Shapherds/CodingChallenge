package com.dimatsoft.codingchallenge.domain.repository

import com.dimatsoft.codingchallenge.data.api.FlickrApi
import com.dimatsoft.codingchallenge.data.mapper.SearchModelResponseToSearchResultMapper
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val flickrApi: FlickrApi,
    private val searchModelResponseToSearchResultMapper: SearchModelResponseToSearchResultMapper
) : LocalRepository {

    override suspend fun getFlickObjects(searchText: String, page: Int): List<String> {
        return flickrApi.getImages(searchText, page).photos.photo.map(
            searchModelResponseToSearchResultMapper
        )
    }
}