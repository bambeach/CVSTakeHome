package com.bambeach.cvstakehome.model

import com.squareup.moshi.JsonClass
import kotlinx.serialization.Serializable

@JsonClass(generateAdapter = true)
@Serializable
data class Image(
    val url: String,
    val title: String,
    val description: String,
    val author: String,
    val date: String
)
