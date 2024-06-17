package com.example.animelistcompose.data.repository

import com.example.animelistcompose.data.api.AnimeApi
import com.example.animelistcompose.data.api.Resource
import com.example.animelistcompose.domain.models.AnimeResponse
import com.example.animelistcompose.domain.models.TrendingAnimeList
import com.example.animelistcompose.domain.repository.TrendingAnimeRepository

class TrendingRepositoryImpl constructor(
    private val animeApi: AnimeApi
) : TrendingAnimeRepository {

    override suspend fun getTrendingAnimeList(): Resource<TrendingAnimeList> {
        return try{
            val trendingAnimeResponse = animeApi.getTrendingAnime()
            Resource.Success(trendingAnimeResponse.toTrendingAnimeList())
        } catch (e:Exception){
            e.printStackTrace()
            Resource.Error(e.cause?.message.toString())
        }
    }

    override suspend fun getAnimeById(id: Int): Resource<AnimeResponse> {
        return try{
            val animeResponse = animeApi.getAnimeById(id).toAnimeResponse()
            Resource.Success(animeResponse)
        } catch (e:Exception){
            e.printStackTrace()
            Resource.Error(e.cause?.message.toString())
        }
    }
}