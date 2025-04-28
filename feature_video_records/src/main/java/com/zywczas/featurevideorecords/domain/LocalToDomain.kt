package com.zywczas.featurevideorecords.domain

import com.zywczas.commonutil.Chars
import com.zywczas.commonutil.extension.fromEpochSecondsToDateTime
import com.zywczas.storevideo.entity.VideoLocal

internal fun VideoLocal.toDomain() = Video(
    title = getDisplayedTimeStamp(timeStamp),
    uri = uri
)

private fun getDisplayedTimeStamp(timeStamp: Long): String {
    val dateTime = timeStamp.fromEpochSecondsToDateTime()

    return buildString {
        append(dateTime.year)
        append(Chars.DASH)
        append(dateTime.monthNumber)
        append(Chars.DASH)
        append(dateTime.dayOfMonth)
        append(Chars.SPACE)
        append(dateTime.hour)
        append(Chars.COLON)
        append(dateTime.minute)
        append(Chars.COLON)
        append(dateTime.second)
    }
}
