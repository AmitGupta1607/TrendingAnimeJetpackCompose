package com.example.animelistcompose.data.api

import com.example.animelistcompose.data.dto.AnimeResponseDTO
import com.example.animelistcompose.data.dto.TrendingAnimeResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApi {

    @GET("trending/anime")
   suspend fun getTrendingAnime():TrendingAnimeResponseDTO

   @GET("anime/{id}")
   suspend fun getAnimeById(@Path("id") path:Int):AnimeResponseDTO

   companion object{
       const val BASE_URL="https://kitsu.io/api/edge/"
   }
}