package com.bambeach.cvstakehome.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@JsonClass(generateAdapter = true)
@Serializable
data class FlickrMedia(
    @Json(name = "m") val imageUrl: String
)
