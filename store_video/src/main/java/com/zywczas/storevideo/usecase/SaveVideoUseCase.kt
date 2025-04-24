package com.zywczas.storevideo.usecase

import com.zywczas.storevideo.dao.VideoDatabaseDao
import com.zywczas.storevideo.entity.VideoLocal
import com.zywczas.storevideo.entity.toCache

class SaveVideoUseCase internal constructor(private val videoDatabaseDao: VideoDatabaseDao) {

    suspend fun save(video: VideoLocal) {
        videoDatabaseDao.dbQuery.insertVideo(video.toCache())
    }
}
