package com.zywczas.storevideo.entity

import com.zywczas.storevideo.cache.Video

fun Video.toLocal() = VideoLocal(
    id = id,
    timeStamp = timeStamp,
    uri = uri,
    description = description
)
