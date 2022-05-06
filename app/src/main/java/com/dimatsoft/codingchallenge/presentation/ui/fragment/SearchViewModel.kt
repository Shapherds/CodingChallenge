package com.dimatsoft.codingchallenge.presentation.ui.fragment

import androidx.lifecycle.ViewModel
import com.dimatsoft.codingchallenge.domain.model.SearchResult
import kotlinx.coroutines.flow.StateFlow

abstract class SearchViewModel : ViewModel() {

    abstract val showLoadingFlow: StateFlow<List<SearchResult>>

    abstract fun getSource(searchText: String)
}