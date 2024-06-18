package com.example.animelistcompose.navigation

import com.example.animelistcompose.domain.models.CoverImage
import kotlinx.serialization.Serializable

@Serializable
data object TrendingAnimeListRoute

@Serializable
data class AnimeItemRoute(val id: Int,val coverImage: String?)