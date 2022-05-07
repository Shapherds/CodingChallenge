package com.dimatsoft.codingchallenge.presentation.ui.fragment

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.dimatsoft.codingchallenge.domain.model.SearchResult
import kotlinx.coroutines.flow.StateFlow
import retrofit2.http.Url

abstract class SearchViewModel : ViewModel() {

    abstract val showLoadingFlow: StateFlow<List<SearchResult>>

    abstract fun getSource(searchText: String)

    abstract fun createUrl(searchResult: SearchResult): String
}