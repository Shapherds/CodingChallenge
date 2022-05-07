package com.dimatsoft.codingchallenge.presentation.ui.fragment

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dimatsoft.codingchallenge.domain.usecase.getHistoryItems.GetSearchHistoryUseCase
import com.dimatsoft.codingchallenge.domain.usecase.saveHistoryItem.SaveSearchHistoryUseCase
import com.dimatsoft.codingchallenge.domain.usecase.search.SearchPlaceUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModelImpl @Inject constructor(
    private val searchPlaceUseCase: SearchPlaceUseCase,
    private val getHistoryItemsUseCase: GetSearchHistoryUseCase,
    private val saveHistoryItemUseCase: SaveSearchHistoryUseCase,
) : SearchViewModel() {

    override val photoUriFlow = MutableStateFlow<PagingData<String>>(PagingData.empty())

    private val lastSearch = MutableStateFlow("")

    override val searchHistory = MutableStateFlow<List<String>>(emptyList())

    init {
        viewModelScope.launch(Dispatchers.Default) {
            querySearchHistory()
        }
    }

    override fun getSource(searchText: String) {
        viewModelScope.launch(Dispatchers.Default) {
            lastSearch.emit(searchText)
            searchPlaceUseCase(searchText).cachedIn(this).collect { data ->
                photoUriFlow.emit(data)
                saveHistoryItemUseCase(searchText)
                querySearchHistory()
            }
        }
    }

    override fun retry() {
        if (lastSearch.value.isNotBlank()) {
            viewModelScope.launch {
                searchPlaceUseCase(lastSearch.value).cachedIn(this).collect { data ->
                    photoUriFlow.emit(data)
                }
            }
        }
    }

    private suspend fun querySearchHistory() {
        getHistoryItemsUseCase().also {
            searchHistory.emit(it)
        }
    }
}