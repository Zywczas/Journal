package com.zywczas.commoncompose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zywczas.commoncompose.components.buttons.PrimaryButton
import com.zywczas.commoncompose.components.buttons.SecondaryButton
import com.zywczas.commoncompose.theme.Spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    title: String,
    text: String,
    primaryButtonText: String,
    secondaryButtonText: String,
    primaryButtonAction: () -> Unit,
    secondaryButtonAction: () -> Unit,
    onDismissRequest: () -> Unit,
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        content = {
            val outerMargin = Spacing.screenBorder
            Column(
                Modifier.padding(
                    start = outerMargin,
                    end = outerMargin,
                    bottom = outerMargin,
                )
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelLarge
                )

                Spacer(Modifier.height(Spacing.listItemVerticalInner))

                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(Modifier.height(Spacing.buttonsSeparator))

                SecondaryButton(
                    onClick = secondaryButtonAction,
                    modifier = Modifier.fillMaxWidth(),
                    text = secondaryButtonText
                )

                Spacer(Modifier.height(Spacing.buttonsSeparator))

                PrimaryButton(
                    onClick = primaryButtonAction,
                    modifier = Modifier.fillMaxWidth(),
                    text = primaryButtonText
                )
            }
        }
    )
}
