package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
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
        TabRow(
            selectedTabIndex = selectedTabIndex
        ) {
            tabs.forEachIndexed { index, tab ->
                val tabTitle = stringResource(tab.tabTitleRes)
                Tab(
                    modifier = Modifier.semantics { contentDescription = "Tab $tabTitle" },
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