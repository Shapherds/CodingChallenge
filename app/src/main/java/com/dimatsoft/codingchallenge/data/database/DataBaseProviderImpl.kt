package com.dimatsoft.codingchallenge.data.database

import com.dimatsoft.codingchallenge.data.model.HistoryItemLocal
import javax.inject.Inject

class DataBaseProviderImpl @Inject constructor(private val historyItemDao: HistoryItemDao) :
    DataBaseProvider {

    override suspend fun saveToHistory(historyItemLocal: HistoryItemLocal) = historyItemDao.setItem(historyItemLocal)

    override suspend fun getHistory() = historyItemDao.getItems()
}