package com.bambeach.cvstakehome.network

import com.bambeach.cvstakehome.model.ImagesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CVSTakeHomeNetworkService {
    companion object {
        const val BASE_URL = "https://api.flickr.com/services/feeds/"
    }
    @GET("photos_public.gne")
    suspend fun getImages(
        @Query("tags") tags: String,
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallback: Int = 1
    ): ImagesResponse
}