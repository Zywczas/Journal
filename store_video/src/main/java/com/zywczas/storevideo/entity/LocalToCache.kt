package com.zywczas.storevideo.entity

import com.zywczas.storevideo.cache.Video

fun VideoLocal.toCache() = Video(
    id = id,
    timeStamp = timeStamp,
    uri = uri,
    description = description
)
