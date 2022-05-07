package com.dimatsoft.codingchallenge.domain.repository

import com.dimatsoft.codingchallenge.data.api.FlickrApi
import com.dimatsoft.codingchallenge.data.database.DataBaseProvider
import com.dimatsoft.codingchallenge.data.mapper.HistoryItemLocalToHistoryItemMapper
import com.dimatsoft.codingchallenge.data.mapper.HistoryItemToHistoryItemLocalMapper
import com.dimatsoft.codingchallenge.data.mapper.SearchModelResponseToSearchResultMapper
import com.dimatsoft.codingchallenge.domain.model.HistoryItem
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val flickrApi: FlickrApi,
    private val searchModelResponseToSearchResultMapper: SearchModelResponseToSearchResultMapper,
    private val historyItemLocalToHistoryItemMapper: HistoryItemLocalToHistoryItemMapper,
    private val historyItemToHistoryItemLocalMapper: HistoryItemToHistoryItemLocalMapper,
    private val dataBaseProvider: DataBaseProvider
) : LocalRepository {

    override suspend fun getFlickObjects(searchText: String, page: Int): List<String> {
        return flickrApi.getImages(searchText, page).photos.photo.map(
            searchModelResponseToSearchResultMapper
        )
    }

    override suspend fun saveHistoryItem(historyItem: HistoryItem) =
        dataBaseProvider.saveToHistory(historyItemToHistoryItemLocalMapper(historyItem))

    override suspend fun getHistory(): List<HistoryItem> =
        dataBaseProvider.getHistory().map(historyItemLocalToHistoryItemMapper)
}