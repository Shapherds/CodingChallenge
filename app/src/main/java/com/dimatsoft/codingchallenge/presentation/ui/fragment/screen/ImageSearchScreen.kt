package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen

import androidx.compose.runtime.Composable
import com.dimatsoft.codingchallenge.R
import com.dimatsoft.codingchallenge.presentation.ui.fragment.SearchViewModel
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.model.Tab

@Composable
fun ImageSearchScreen(viewModel: SearchViewModel) {
    TitleTabRow(
        tabs = listOf(
            Tab(R.string.tab_search_history) {
                SearchHistory(viewModel = viewModel)
            },
            Tab(R.string.tab_search_results) {
                SearchResults(viewModel = viewModel)
            },
        )
    )
}
