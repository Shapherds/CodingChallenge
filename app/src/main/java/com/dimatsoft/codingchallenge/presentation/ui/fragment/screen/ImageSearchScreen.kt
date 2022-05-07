package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import com.dimatsoft.codingchallenge.R
import com.dimatsoft.codingchallenge.presentation.ui.fragment.SearchViewModel
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.model.Tab
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view.SearchHistory
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view.SearchResults
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view.TitleTabRow

@Composable
fun ImageSearchScreen(viewModel: SearchViewModel) {
    Column {
        var selectedTabIndex by remember { mutableStateOf(0) }
        SearchView(onSearch = {
            viewModel.getSource(it)
            selectedTabIndex = 1
        })
        TitleTabRow(
            tabs = listOf(
                Tab(R.string.tab_search_history) {
                    SearchHistory(
                        viewModel = viewModel,
                        onHistorySelected = {
                            viewModel.getSource(it)
                            selectedTabIndex = 1
                        }
                    )
                },
                Tab(R.string.tab_search_results) {
                    SearchResults(viewModel = viewModel)
                },
            ),
            onTabSelected = { index -> selectedTabIndex = index },
            selectedTabIndex
        )
    }
}
