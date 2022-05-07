package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.dimatsoft.codingchallenge.R

/**
 * Real time, search while typing can be supported later.
 */
@Composable
fun SearchView(
    onSearch: (String) -> Unit
) {
    var searchSelected by remember { mutableStateOf(false) }
    var searchText by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    TopAppBar(modifier = Modifier.height(52.dp)) {
        IconButton(onClick = {
            searchSelected = !searchSelected
            if (searchSelected) {
                focusRequester.requestFocus()
            } else {
                searchText = ""
                focusManager.clearFocus()
            }
        }) {
            Icon(
                imageVector = if (searchSelected) Icons.Filled.Clear else Icons.Filled.Search,
                contentDescription = stringResource(id = R.string.description_search_icon)
            )
        }
        OutlinedTextField(
            value = searchText, onValueChange = { value -> searchText = value },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.White,
                cursorColor = Color.White
            ),
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                onSearch(searchText)
                focusManager.clearFocus()
                searchSelected = false
            })
        )
    }
}
