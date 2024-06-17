package com.example.animelistcompose.presentation.trendingAnime

import com.example.animelistcompose.domain.models.AnimeData

data class TrendingAnimeListState(
    val trendingAnimeList: List<AnimeData> = emptyList(),
    val isLoading: Boolean = false
)