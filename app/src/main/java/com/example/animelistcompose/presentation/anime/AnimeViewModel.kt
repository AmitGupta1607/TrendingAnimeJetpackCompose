package com.example.animelistcompose.presentation.anime

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.animelistcompose.data.api.Resource
import com.example.animelistcompose.domain.repository.TrendingAnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val trendingAnimeRepository: TrendingAnimeRepository,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private var _animeState = MutableStateFlow(AnimeItemState())
    var animeState = _animeState.asStateFlow()

     suspend fun getAnimeById(id:Int){
        _animeState.update {
            it.copy(loading=true)
        }
        when(val response = trendingAnimeRepository.getAnimeById(id)){
            is Resource.Success->{
                val data = response.data
                data?.let { animeResponse ->
                    _animeState.update {
                        it.copy(animeData = animeResponse.animeData,loading = false)
                    }
                }
            }
            is Resource.Error->{

            }
        }
    }

}