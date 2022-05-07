package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.model.Tab

/**
 * A row of tabs with a title and a composable function that is called when specific tab is
 * selected.
 */
@Composable
fun TitleTabRow(
    tabs: List<Tab>,
    onTabSelected: (Int) -> Unit,
    selectedTabIndex: Int = 0
) {
    Column {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = { onTabSelected(index) },
                    text = {
                        Text(stringResource(tab.tabTitleRes))
                    },
                )
            }
        }
        tabs[selectedTabIndex].also {
            it.onSelected()
        }
    }
}