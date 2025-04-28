package com.zywczas.commonutil.extension

import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun Long.fromEpochSecondsToDateTime(): LocalDateTime = Instant.fromEpochSeconds(this).toLocalDateTime(TimeZone.currentSystemDefault())
