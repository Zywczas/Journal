package com.zywczas.commoncompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import com.zywczas.commoncompose.R
import com.zywczas.commoncompose.theme.Spacing

@Composable
fun VideoListItem(
    title: String,
    onClick: () -> Unit
) {
    Column(
        Modifier.clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.video_placeholder),
            contentDescription = null,
            modifier = Modifier.semantics {
                invisibleToUser()
            }
        )

        Spacer(Modifier.height(Spacing.listItemVerticalInner))

        Text(
            text = title,
            style = MaterialTheme.typography.labelSmall
        )
    }
}
