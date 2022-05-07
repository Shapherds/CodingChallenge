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

    override val showLoadingFlow = MutableStateFlow<PagingData<String>>(PagingData.empty())

    override fun getSource(searchText: String) {
        viewModelScope.launch {
            searchPlaceUseCase(searchText).cachedIn(this).collect { data ->
                showLoadingFlow.emit(data)
            }
        }
    }
}