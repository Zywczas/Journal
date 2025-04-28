package com.zywczas.storevideo.entity

data class VideoLocal(
    val timeStamp: Long,
    val uri: String,
    val description: String?,
    val id: Long? = null,
)
