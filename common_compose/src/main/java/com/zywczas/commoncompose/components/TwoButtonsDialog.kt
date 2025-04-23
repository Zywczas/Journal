package com.zywczas.commoncompose.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.zywczas.commoncompose.theme.Theme

@Composable
fun TwoButtonsDialog(
    title: String,
    text: String,
    confirmButtonText: String,
    dismissButtonText: String,
    onConfirmClick: () -> Unit,
    onDismissClick: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissClick,
        confirmButton = {
            DialogButton(text = confirmButtonText, onClick = onConfirmClick)
        },
        dismissButton = {
            DialogButton(text = dismissButtonText, onClick = onDismissClick)
        },
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.labelMedium,
            )
        },
        text = {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = true,
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTwoButtonsDialog() {
    Theme.Preview {
        TwoButtonsDialog(
            title = "Lorem Ipsum",
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
            confirmButtonText = "Confirm",
            dismissButtonText = "Cancel",
            onConfirmClick = {},
            onDismissClick = {},
        )
    }
}
