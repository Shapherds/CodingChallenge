package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.dimatsoft.codingchallenge.R
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.model.Tab
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view.SearchHistory
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view.SearchResults
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view.SearchView
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view.TitleTabRow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun ImageSearchScreen(
    photoUriFlow: StateFlow<PagingData<String>>,
    searchHistory: StateFlow<List<String>>,
    getPhoto: (String) -> Unit,
    retry: () -> Unit
) {


    Column {
        var selectedTabIndex by remember { mutableStateOf(0) }
        var searchText by remember { mutableStateOf("") }

        SearchView(
            onTextChanged = { text ->
                searchText = text
            },
            onSearch = {
                getPhoto(searchText)
                selectedTabIndex = 1
            },
            onClear = {
                searchText = ""
            }, searchText
        )
        TitleTabRow(
            tabs = listOf(
                Tab(R.string.tab_search_history) {
                    SearchHistory(
                        historyRes = searchHistory.collectAsState().value,
                        onHistorySelected = {
                            searchText = it
                            getPhoto(it)
                            selectedTabIndex = 1
                        }
                    )
                },
                Tab(R.string.tab_search_results) {
                    SearchResults(
                        res = photoUriFlow.collectAsLazyPagingItems(),
                        retryRequest = retry
                    )
                },
            ),
            onTabSelected = { index -> selectedTabIndex = index },
            selectedTabIndex
        )
    }
}
