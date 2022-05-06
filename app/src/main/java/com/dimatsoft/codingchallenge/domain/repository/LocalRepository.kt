package com.dimatsoft.codingchallenge.domain.repository

import com.dimatsoft.codingchallenge.domain.model.SearchResult

interface LocalRepository {

    suspend fun getFlickObjects(searchText: String): List<SearchResult>
}