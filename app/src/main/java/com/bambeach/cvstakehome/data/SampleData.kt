package com.bambeach.cvstakehome.data

import com.bambeach.cvstakehome.model.FlickrMedia
import com.bambeach.cvstakehome.model.Image
import com.bambeach.cvstakehome.model.ImageResponse

val sampleImageResponse = ImageResponse(
    media = FlickrMedia(
        imageUrl = "https://picsum.photos/200"
    ),
    title = "Sample Image 1",
    description = "This is a sample image",
    author = "John Doe",
    date = "2024-09-27T18:34:59-08:00"
)

val sampleImage: Image = Image(
    url = "https://picsum.photos/200",
    title = "Sample Image 1",
    description = "This is a sample image",
    author = "John Doe",
    date = "2023-04-01"
)

val sampleImage1: Image = Image(
    url = "https://picsum.photos/201",
    title = "Sample Image 2",
    description = "This is a sample image",
    author = "John Doe",
    date = "2023-04-01"
)

val sampleImageList: List<Image> = listOf(sampleImage, sampleImage1)