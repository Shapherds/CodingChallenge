package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.dimatsoft.codingchallenge.presentation.ui.fragment.SearchViewModel

@Composable
internal fun SearchScreen(viewModel: SearchViewModel) {

    val res = viewModel.showLoadingFlow.collectAsState()

    viewModel.getSource("Berlin")
    Column {
        LazyColumn {
            items(res.value) {
                Log.e("Logs", res.value.toString())
            }
        }
    }
}