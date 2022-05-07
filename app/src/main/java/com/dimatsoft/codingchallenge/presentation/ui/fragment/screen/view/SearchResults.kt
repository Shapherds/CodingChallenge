package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.dimatsoft.codingchallenge.R
import com.dimatsoft.codingchallenge.presentation.ui.fragment.SearchViewModel
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view.dialogs.ErrorDialog
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view.dialogs.LoadingDialog
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SearchResults(viewModel: SearchViewModel) {

    val res: LazyPagingItems<String> = viewModel.photoUriFlow.collectAsLazyPagingItems()

    when (res.loadState.refresh) {
        is LoadState.Loading -> {
            LoadingDialog()
        }
        is LoadState.Error -> {
            ErrorDialog(onDismiss = {viewModel.retry()})
        }
    }
    LazyColumn {
        items(res.itemCount) { item ->
            res[item]?.let { photoUrl ->
                DrawImage(photoUrl)
            }
        }
    }
}

@Composable
fun DrawImage(photoUrl: String) {
    GlideImage(
        imageModel = photoUrl,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
            .border(2.dp, Color.Blue),
        placeHolder = ImageBitmap.imageResource(R.drawable.placeholder)
    )
}