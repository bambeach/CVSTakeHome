package com.bambeach.cvstakehome.data.di

import android.content.Context
import com.bambeach.cvstakehome.data.ImageRepository
import com.bambeach.cvstakehome.network.CVSTakeHomeNetworkService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideHttpClient(
        @ApplicationContext context: Context
    ): OkHttpClient = OkHttpClient.Builder()
        .cache(Cache(File(context.cacheDir, "http_cache"), (20 * 1024 * 1024).toLong()))
        .build()

    @Provides
    @Singleton
    fun provideNetworkService(
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): CVSTakeHomeNetworkService {
        return Retrofit.Builder()
            .baseUrl(CVSTakeHomeNetworkService.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(CVSTakeHomeNetworkService::class.java)
    }

    @Provides
    @Singleton
    fun provideImageRepository(
        networkService: CVSTakeHomeNetworkService
    ): ImageRepository {
        return ImageRepository(networkService)
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
}