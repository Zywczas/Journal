package com.zywczas.featurevideorecords.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.zywczas.commonactivityresult.GoToAppSettings
import com.zywczas.commonactivityresult.permissions.Permission
import com.zywczas.commonactivityresult.permissions.PermissionRequester
import com.zywczas.commonactivityresult.permissions.PermissionUtil
import com.zywczas.commoncompose.components.BottomBarInsetSpacer
import com.zywczas.commoncompose.components.BottomSheet
import com.zywczas.commoncompose.components.FAB
import com.zywczas.commoncompose.components.Toolbar
import com.zywczas.commoncompose.components.TwoButtonsDialog
import com.zywczas.commoncompose.components.VideoListItem
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.featurevideorecords.R
import com.zywczas.featurevideorecords.viewmodel.VideoRecordsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun VideoRecordsScreen() {
    val viewModel: VideoRecordsViewModel = koinViewModel()

    VideoRecordsScreen(
        videos = viewModel.videos,
    )

    LaunchedEffect(Unit) {
        viewModel.init()
    }
}

@Composable
private fun VideoRecordsScreen(
    videos: List<String>,
) {
    val context = LocalContext.current
    var showPermissionsRationaleDialog by remember { mutableStateOf(false) }
    val closePermissionsRationaleDialogAction = { showPermissionsRationaleDialog = false }
    var askForPermission by remember { mutableStateOf(false) }
    val closePermissionRequesterAction = { askForPermission = false }
    var showGoToSettingsMessage by remember { mutableStateOf(false) }
    val closeGoToSettingsMessage = { showGoToSettingsMessage = false }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    Scaffold(
        content = { _ ->
            Column {
                Toolbar(stringResource(R.string.video_records_screen_title))

                Spacer(Modifier.height(Spacing.screenComponentsVertical))

                LazyColumn(
                    Modifier.padding(horizontal = Spacing.screenBorder)
                ) {
                    items(videos) { item ->
                        VideoListItem(
                            title = item,
                            onClick = {}
                        )
                    }

                    item {
                        BottomBarInsetSpacer()
                    }
                }
            }
        },
        floatingActionButton = {
            FAB(
                text = stringResource(R.string.add_video),
                onClick = {
                    if (PermissionUtil.isGranted(Permission.Camera, context).not()) {
                        showPermissionsRationaleDialog = true
                    } else {
                        // check storage permission
                    }
                },
            )
        }
    )

    if (showPermissionsRationaleDialog) {
        PermissionsDialog(
            onCancelClick = closePermissionsRationaleDialogAction,
            onConfirmClick = {
                closePermissionsRationaleDialogAction()
                askForPermission = true
            }
        )
    }

    if (askForPermission) {
        PermissionRequester(
            permission = Permission.Camera,
            onDenied = closePermissionRequesterAction,
            onGranted = {
                closePermissionRequesterAction()
                // check storage permission
            },
            onDeniedAndNeverAskAgain = {
                closePermissionRequesterAction()
                showGoToSettingsMessage = true
            }
        )
    }

    if (showGoToSettingsMessage) {
        GoToSettings(
            onCancel = closeGoToSettingsMessage,
            onReturnFromSettings = {
                closeGoToSettingsMessage()
                if (PermissionUtil.isGranted(Permission.Camera, context)) {
                    // check storage permission
                }
            }
        )
    }
}

@Composable
private fun PermissionsDialog(
    onCancelClick: () -> Unit,
    onConfirmClick: () -> Unit,
) {
    TwoButtonsDialog(
        title = stringResource(com.zywczas.commonutil.R.string.permissions_required_title),
        text = stringResource(R.string.video_permissions_required_message),
        confirmButtonText = stringResource(com.zywczas.commonutil.R.string.confirm_button),
        dismissButtonText = stringResource(com.zywczas.commonutil.R.string.cancel_button),
        onConfirmClick = {
            onCancelClick()
            onConfirmClick()
        },
        onDismissClick = onCancelClick
    )
}

@Composable
private fun GoToSettings(
    onCancel: () -> Unit,
    onReturnFromSettings: () -> Unit,
) {
    GoToAppSettings(
        onReturnFromSettings = onReturnFromSettings,
        content = { goToSettingsAction: () -> Unit ->
            BottomSheet(
                title = stringResource(com.zywczas.commonutil.R.string.permissions_required_title),
                text = stringResource(R.string.video_permissions_required_message),
                primaryButtonText = stringResource(com.zywczas.commonutil.R.string.confirm_button),
                secondaryButtonText = stringResource(com.zywczas.commonutil.R.string.cancel_button),
                primaryButtonAction = goToSettingsAction,
                secondaryButtonAction = onCancel,
                onDismissRequest = onCancel
            )
        }
    )
}
