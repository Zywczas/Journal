package com.zywczas.featurevideorecords.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.zywczas.commoncompose.components.BottomBarInsetSpacer
import com.zywczas.commoncompose.components.Toolbar
import com.zywczas.commoncompose.components.VideoListItem
import com.zywczas.commoncompose.theme.Spacing
import com.zywczas.featurevideorecords.R
import com.zywczas.featurevideorecords.viewmodel.VideoRecordsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun VideoRecordsScreen() {
    val viewModel: VideoRecordsViewModel = koinViewModel()

    VideoRecordsScreen(
        videos = viewModel.videos
    )

    LaunchedEffect(Unit) {
        viewModel.init()
    }
}

@Composable
private fun VideoRecordsScreen(
    videos: List<String>
) {
    Column {
        Toolbar(stringResource(R.string.video_records_screen_title))

        Spacer(Modifier.height(Spacing.screenComponentsVertical))

        LazyColumn {
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
}
