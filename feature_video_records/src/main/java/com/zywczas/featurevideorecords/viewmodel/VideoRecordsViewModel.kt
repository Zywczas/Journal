package com.zywczas.featurevideorecords.viewmodel

import android.net.Uri
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.zywczas.commonutil.BaseViewModel
import com.zywczas.featurevideorecords.domain.Video
import com.zywczas.featurevideorecords.domain.toDomain
import com.zywczas.storevideo.entity.VideoLocal
import com.zywczas.storevideo.usecase.GetVideosUseCase
import com.zywczas.storevideo.usecase.SaveVideoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock

@Stable
internal class VideoRecordsViewModel(
    private val saveVideoUseCase: SaveVideoUseCase,
    private val getVideosUseCase: GetVideosUseCase
) : BaseViewModel() {

    var videos by mutableStateOf<List<Video>>(emptyList())
        private set

    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            getVideos()
        }
    }

    fun saveVideo(uri: Uri?) {
        viewModelScope.launch(Dispatchers.IO) {
            uri?.let {
                saveVideoUseCase.save(
                    VideoLocal(
                        uri = uri.path!!,
                        timeStamp = Clock.System.now().epochSeconds,
                        description = null,
                    )
                )
                getVideos()
            }
        }
    }

    private suspend fun getVideos() {
        videos = getVideosUseCase.get().map { it.toDomain() }
    }
}
