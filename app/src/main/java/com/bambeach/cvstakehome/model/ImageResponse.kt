package com.bambeach.cvstakehome.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.OffsetDateTime

@JsonClass(generateAdapter = true)
data class ImageResponse(
    val media: FlickrMedia,
    val title: String,
    val description: String,
    val author: String,
    @Json(name = "date_taken") val date: String
)

fun ImageResponse.toImage(): Image {
    val date = OffsetDateTime.parse(date)
    return Image(
        url = media.imageUrl,
        title = title,
        description = description,
        author = author,
        date = "${date.dayOfMonth} ${date.month} ${date.year} ${date.hour}:${date.minute}"
    )
}
