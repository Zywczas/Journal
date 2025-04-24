package com.zywczas.commonactivityresult.permissions

import androidx.activity.compose.LocalActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat

@Composable
fun PermissionRequester(
    permission: Permission,
    onGranted: () -> Unit,
    onDenied: () -> Unit,
    onDeniedAndNeverAskAgain: () -> Unit,
) {
    val requiredPermission = permission.value
    val context = LocalContext.current
    val activity = LocalActivity.current

    if (PermissionUtil.isGranted(permission, context)) {
        onGranted()
    } else {
        val launcher: ManagedActivityResultLauncher<String, Boolean> =
            rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { permissionGranted: Boolean ->
                if (permissionGranted) {
                    onGranted()
                } else if (activity != null && ActivityCompat.shouldShowRequestPermissionRationale(activity, requiredPermission).not()) {
                    onDeniedAndNeverAskAgain()
                } else {
                    onDenied()
                }
            }
        LaunchedEffect(Unit) {
            launcher.launch(requiredPermission)
        }
    }
}
