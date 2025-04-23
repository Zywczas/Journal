package com.zywczas.featurevideorecords

import com.zywczas.featurevideorecords.viewmodel.VideoRecordsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val featureVideoRecordsModule = module {
    viewModelOf(::VideoRecordsViewModel)
}
