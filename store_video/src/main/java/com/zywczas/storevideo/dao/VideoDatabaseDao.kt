package com.zywczas.storevideo.dao

import app.cash.sqldelight.db.SqlDriver
import com.zywczas.storevideo.cache.VideoDatabase

internal class VideoDatabaseDao(driver: SqlDriver) {

    private val database = VideoDatabase.Companion.invoke(driver)
    val dbQuery = database.videoDatabaseQueries
}
