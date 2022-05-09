package com.dimatsoft.codingchallenge.presentation.ui.fragment.screen.view.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.dimatsoft.codingchallenge.R


@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun ErrorDialog(onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(2.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp),
                text = stringResource(id = R.string.default_err_mess),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.subtitle2,
                color = Color.Black
            )
            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .clickable {
                        onDismiss()
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Divider()
                Text(
                    modifier = Modifier.padding(vertical = 14.dp),
                    text = stringResource(R.string.retry),
                    color = Color.Green
                )
            }

        }
    }
}