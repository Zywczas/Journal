package com.zywczas.commonactivityresult.media.video

import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun CaptureVideo(
    onResult: (Uri?) -> Unit
) {
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        onResult(result.data?.data)
    }
    LaunchedEffect(Unit) {
        launcher.launch(Intent(MediaStore.ACTION_VIDEO_CAPTURE))
    }
}
