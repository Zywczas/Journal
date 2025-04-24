package com.zywczas.storevideo

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.zywczas.storevideo.cache.VideoDatabase
import com.zywczas.storevideo.dao.VideoDatabaseDao
import com.zywczas.storevideo.usecase.GetVideosUseCase
import com.zywczas.storevideo.usecase.SaveVideoUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val storeVideoModule = module {
    single<SqlDriver> { AndroidSqliteDriver(VideoDatabase.Schema, get(), "VideoDatabase.db") }
    singleOf(::VideoDatabaseDao)
    singleOf(::SaveVideoUseCase)
    singleOf(::GetVideosUseCase)
}
