package com.example.animelistcompose.domain.repository

import com.example.animelistcompose.data.api.Resource
import com.example.animelistcompose.domain.models.AnimeResponse
import com.example.animelistcompose.domain.models.TrendingAnimeList

interface TrendingAnimeRepository {

    suspend fun getTrendingAnimeList():Resource<TrendingAnimeList>

    suspend fun getAnimeById(id:Int):Resource<AnimeResponse>
}