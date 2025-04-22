package com.zywczas.journal.di

import com.zywczas.featurevideorecords.featureVideoRecordsModule
import org.koin.core.module.Module

val appKoinModules: List<Module> = listOf(
    featureVideoRecordsModule,
)
