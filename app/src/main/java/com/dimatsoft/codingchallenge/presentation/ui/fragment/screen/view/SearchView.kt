package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
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
    onTextChanged: (String) -> Unit,
    onSearch: () -> Unit,
    onClear: () -> Unit,
    initialText: String = "",
) {
    var searchSelected by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    TopAppBar(modifier = Modifier.height(52.dp)) {
        IconButton(onClick = {
            searchSelected = !searchSelected
            if (searchSelected) {
                focusRequester.requestFocus()
            } else {
                onClear()
                focusManager.clearFocus()
            }
        }) {
            Icon(
                imageVector = if (searchSelected) Icons.Filled.Clear else Icons.Filled.Search,
                contentDescription = stringResource(id = R.string.description_search_icon)
            )
        }
        OutlinedTextField(
            value = initialText, onValueChange = { value -> onTextChanged(value) },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .onFocusChanged { state -> searchSelected = state.isFocused },
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
                onSearch()
                focusManager.clearFocus()
                searchSelected = false
            })
        )
    }
}
