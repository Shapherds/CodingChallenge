package com.dimatsoft.codingchallenge.data.database

import com.dimatsoft.codingchallenge.data.model.HistoryItemLocal

interface DataBaseProvider {

    suspend fun saveToHistory(historyItemLocal: HistoryItemLocal)

    suspend fun getHistory(): List<HistoryItemLocal>
}