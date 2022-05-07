package com.dimatsoft.codingchallenge.domain.repository

import com.dimatsoft.codingchallenge.domain.model.HistoryItem

interface LocalRepository {

    suspend fun getFlickObjects(
        searchText: String,
        page: Int
    ): List<String>

    suspend fun saveHistoryItem(historyItem: HistoryItem)
    suspend fun getHistory(): List<HistoryItem>
}