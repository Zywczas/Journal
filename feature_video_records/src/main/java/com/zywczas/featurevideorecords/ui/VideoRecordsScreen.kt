package com.zywczas.featurevideorecords.ui

import androidx.compose.runtime.Composable
import com.zywczas.featurevideorecords.viewmodel.VideoRecordsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun VideoRecordsScreen() {
    val viewModel: VideoRecordsViewModel = koinViewModel()

}
