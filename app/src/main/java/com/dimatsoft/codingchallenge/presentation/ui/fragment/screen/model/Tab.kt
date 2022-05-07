package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.model

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable

/**
 * A simple tab with a title and function that will be called when tab is selected.
 */
data class Tab(@StringRes val tabTitleRes: Int, val onSelected: @Composable () -> Unit)