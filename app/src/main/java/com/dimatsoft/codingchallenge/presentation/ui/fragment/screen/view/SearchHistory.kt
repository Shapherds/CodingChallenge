package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dimatsoft.codingchallenge.R
import com.dimatsoft.codingchallenge.presentation.ui.fragment.SearchViewModel

@Composable
fun SearchHistory(viewModel: SearchViewModel, onHistorySelected: (String) -> Unit) {
    val history = viewModel.searchHistory.collectAsState()

    history.value.also {
        if (it.isEmpty()) {
            EmptyHistory()
        } else {
            HistoryRecords(it, onHistorySelected)
        }
    }

}

@Composable
fun EmptyHistory() {
    Column(
        modifier = Modifier.padding(vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.no_history),
            fontSize = 22.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun HistoryRecords(records: List<String>, onHistorySelected: (String) -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        records.forEach { title ->
            HistoryRecord(title, onHistorySelected)
        }
    }
}

@Composable
fun HistoryRecord(text: String, onSelected: (String) -> Unit) {
    Row(
        modifier = Modifier.clickable { onSelected(text) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.description_history_record),
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
        )
    }
    Divider(color = MaterialTheme.colors.primary, thickness = 2.dp)
}
