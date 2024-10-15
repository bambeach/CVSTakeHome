package com.bambeach.cvstakehome.data

import com.bambeach.cvstakehome.model.Image
import com.bambeach.cvstakehome.model.toImage
import com.bambeach.cvstakehome.network.CVSTakeHomeNetworkService
import javax.inject.Inject

class ImageRepository @Inject constructor(
    private val networkService: CVSTakeHomeNetworkService
) {
    suspend fun getImages(
        tags: String,
        format: String = "json",
        noJsonCallback: Int = 1
    ): List<Image> {
        val response = networkService.getImages(tags, format, noJsonCallback)
        return response.items.map { image ->
            image.toImage()
        }
    }
}