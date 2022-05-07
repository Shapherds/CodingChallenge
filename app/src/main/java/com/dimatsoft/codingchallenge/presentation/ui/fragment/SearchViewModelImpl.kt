package com.dimatsoft.codingchallenge.presentation.ui.fragment

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dimatsoft.codingchallenge.domain.usecase.search.SearchPlaceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModelImpl @Inject constructor(
    private val searchPlaceUseCase: SearchPlaceUseCase
) : SearchViewModel() {

    override val photoUriFlow = MutableStateFlow<PagingData<String>>(PagingData.empty())

    private val lastSearch = MutableStateFlow("")

    override fun getSource(searchText: String) {
        viewModelScope.launch {
            lastSearch.emit(searchText)
            searchPlaceUseCase(searchText).cachedIn(this).collect { data ->
                photoUriFlow.emit(data)
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
}