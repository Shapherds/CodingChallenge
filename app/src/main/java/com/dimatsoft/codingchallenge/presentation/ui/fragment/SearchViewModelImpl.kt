package com.dimatsoft.codingchallenge.presentation.ui.fragment

import androidx.lifecycle.viewModelScope
import com.dimatsoft.codingchallenge.domain.model.SearchResult
import com.dimatsoft.codingchallenge.domain.usecase.SearchPlaceUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModelImpl @Inject constructor(
    private val searchPlaceUseCase: SearchPlaceUseCase
) : SearchViewModel() {

    override val showLoadingFlow = MutableStateFlow<List<SearchResult>>(listOf())

    override fun getSource(searchText: String) {
        viewModelScope.launch {
            showLoadingFlow.emit(searchPlaceUseCase(searchText))
        }
    }

    override fun createUrl(searchResult: SearchResult): String =
        "https://farm${searchResult.farm}.static.flickr.com/${searchResult.server}/${searchResult.id}_${searchResult.secret}.jpg"
}