package com.example.animelistcompose.presentation.trendingAnime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animelistcompose.data.api.Resource
import com.example.animelistcompose.domain.repository.TrendingAnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TrendingAnimeListViewmodel @Inject constructor(
    private val animeRepository: TrendingAnimeRepository
) : ViewModel() {

    private var _state = MutableStateFlow(TrendingAnimeListState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            fetchTrendingAnimeList()
        }
    }

    private suspend fun fetchTrendingAnimeList() {
        _state.update {
            it.copy(isLoading = true)
        }
        when (val response = animeRepository.getTrendingAnimeList()) {
            is Resource.Success -> {
                val data = response.data
                data?.let { trendingAnimeList ->
                    _state.update {
                        it.copy(trendingAnimeList = trendingAnimeList.data, isLoading = false)
                    }
                }
            }

            is Resource.Error -> {

            }
        }
    }
}