package com.dimatsoft.codingchallenge.presentation.ui.fragment

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.dimatsoft.codingchallenge.domain.model.SearchResult
import kotlinx.coroutines.flow.StateFlow
import retrofit2.http.Url

abstract class SearchViewModel : ViewModel() {

    abstract val showLoadingFlow: StateFlow<PagingData<SearchResult>>

    abstract fun getSource(searchText: String)

    abstract fun createUrl(searchResult: SearchResult): String
}