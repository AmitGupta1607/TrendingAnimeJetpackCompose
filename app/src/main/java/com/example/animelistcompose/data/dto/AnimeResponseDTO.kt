package com.example.animelistcompose.data.dto

import com.example.animelistcompose.domain.models.AnimeResponse

data class AnimeResponseDTO(
    val data:DataDto
){
    fun toAnimeResponse():AnimeResponse{
        return AnimeResponse(animeData=data.toData())
    }
}