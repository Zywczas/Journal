package com.zywczas.storevideo.usecase

import com.zywczas.storevideo.dao.VideoDatabaseDao
import com.zywczas.storevideo.entity.VideoLocal
import com.zywczas.storevideo.entity.toLocal

class GetVideosUseCase internal constructor(private val videoDatabaseDao: VideoDatabaseDao) {

    suspend fun get(): List<VideoLocal> = videoDatabaseDao.dbQuery.getVideos().executeAsList().map { it.toLocal() }
}
