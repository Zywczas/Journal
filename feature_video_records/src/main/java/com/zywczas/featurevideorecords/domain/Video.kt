package com.zywczas.featurevideorecords.domain

import androidx.compose.runtime.Immutable

@Immutable
internal data class Video(
    val title: String,
    val uri: String
)
