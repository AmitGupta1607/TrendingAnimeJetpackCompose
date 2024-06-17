package com.example.animelistcompose.di

import com.example.animelistcompose.data.api.AnimeApi
import com.example.animelistcompose.data.repository.TrendingRepositoryImpl
import com.example.animelistcompose.domain.repository.TrendingAnimeRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(AnimeApi.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun providesAnimeApi(retrofit: Retrofit): AnimeApi {
        return retrofit.create(AnimeApi::class.java)
    }

    @Provides
    @Singleton
    fun providesTrendingRepository(animeApi: AnimeApi):TrendingAnimeRepository {
       return TrendingRepositoryImpl(animeApi)
    }

}