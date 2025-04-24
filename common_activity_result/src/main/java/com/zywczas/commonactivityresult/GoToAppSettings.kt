package com.zywczas.commonactivityresult

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun GoToAppSettings(
    onReturnFromSettings: () -> Unit,
    content: @Composable (goToSettingsAction: () -> Unit) -> Unit
) {
    val context = LocalContext.current
    val activityResultLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            onReturnFromSettings()
        }
    val goToSettingsAction = {
        activityResultLauncher.launch(
            Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                data = Uri.fromParts("package", context.packageName, null)
            }
        )
    }
    content(goToSettingsAction)
}
