package com.zywczas.commoncompose.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.invisibleToUser
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zywczas.commoncompose.theme.Theme

@Composable
fun FAB(
    text: String,
    onClick: () -> Unit,
    imageVector: ImageVector? = null,
) {
    FloatingActionButton(
        onClick = onClick,
        content = {
            Row(Modifier.padding(horizontal = 4.dp)) {
                imageVector?.let {
                    Icon(
                        imageVector = imageVector,
                        contentDescription = null,
                        modifier = Modifier.semantics {
                            invisibleToUser()
                        }
                    )

                    Spacer(modifier = Modifier.width(4.dp))
                }

                Text(
                    text = text,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    )
}

@Preview
@Composable
private fun PreviewFAB() {
    Theme.Preview {
        FAB(
            text = "Add Video",
            imageVector = Icons.Filled.Add,
            onClick = {}
        )
    }
}
