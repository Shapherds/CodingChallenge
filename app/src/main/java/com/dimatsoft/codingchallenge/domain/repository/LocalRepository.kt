package com.dimatsoft.codingchallenge.domain.repository

interface LocalRepository {

    suspend fun getFlickObjects(
        searchText: String,
        page: Int
    ): List<String>
}