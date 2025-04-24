package com.zywczas.journal.di

import com.zywczas.featurevideorecords.featureVideoRecordsModule
import com.zywczas.storevideo.storeVideoModule
import org.koin.core.module.Module

val appKoinModules: List<Module> = listOf(
    featureVideoRecordsModule,
    storeVideoModule,
)
