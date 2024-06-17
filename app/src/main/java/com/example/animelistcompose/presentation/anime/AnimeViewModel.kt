package com.example.animelistcompose.presentation.anime

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.animelistcompose.domain.repository.TrendingAnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AnimeViewModel @Inject constructor(
    trendingAnimeRepository: TrendingAnimeRepository,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {
}