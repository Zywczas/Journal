package com.zywczas.featurevideorecords.viewmodel

import android.net.Uri
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.zywczas.commonutil.BaseViewModel
import com.zywczas.commonutil.logD

@Stable
internal class VideoRecordsViewModel : BaseViewModel() {

    var videos by mutableStateOf<List<String>>(emptyList())

    fun init() {
        videos = mockedVideos
    }

    fun saveVideo(uri: Uri?) {
        logD(uri)
    }
}

private val mockedVideos = listOf(
    "video1",
    "video2",
    "video3",
    "video4",
    "video5",
    "video6",
)
