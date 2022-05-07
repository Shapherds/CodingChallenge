package com.dimatsoft.codingchallenge.presentation.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.StateFlow

abstract class SearchViewModel : ViewModel() {

    abstract val photoUriFlow: StateFlow<PagingData<String>>

    abstract fun getSource(searchText: String)

    abstract fun retry()
}