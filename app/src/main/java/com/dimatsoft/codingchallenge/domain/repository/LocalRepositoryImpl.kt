package com.dimatsoft.codingchallenge.domain.repository

import android.util.Log
import com.dimatsoft.codingchallenge.data.api.FlickrApi
import com.dimatsoft.codingchallenge.data.mapper.SearchModelResponseToSearchResultMapper
import com.dimatsoft.codingchallenge.domain.model.SearchResult
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val flickrApi: FlickrApi,
    private val searchModelResponseToSearchResultMapper: SearchModelResponseToSearchResultMapper
) : LocalRepository {

    override suspend fun getFlickObjects(searchText: String): List<SearchResult> {
        Log.e("Logs", "OK! $flickrApi")
        return flickrApi.getImages().photos.photo.map(searchModelResponseToSearchResultMapper)
    }
}