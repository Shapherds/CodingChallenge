package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.dimatsoft.codingchallenge.presentation.ui.fragment.SearchViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
internal fun SearchScreen(viewModel: SearchViewModel) {

    val res = viewModel.showLoadingFlow.collectAsLazyPagingItems()

    viewModel.getSource("Berlin")

    Column {
        LazyColumn {
            items(res.itemCount) { item ->
                res[item]?.let { photoUrl ->
                    GlideImage(
                        imageModel = photoUrl,
                        modifier = Modifier.fillMaxWidth().height(200.dp)
                    )
                }
            }
        }
    }
}