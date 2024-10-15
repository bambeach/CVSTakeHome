package com.bambeach.cvstakehome.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImagesResponse(
    val title: String,
    val link: String,
    val description: String,
    val modified: String,
    val generator: String,
    val items: List<ImageResponse>
)
