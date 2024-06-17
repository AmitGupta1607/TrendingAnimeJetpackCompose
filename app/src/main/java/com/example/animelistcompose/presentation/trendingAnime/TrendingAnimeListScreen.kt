package com.example.animelistcompose.presentation.trendingAnime

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animelistcompose.domain.models.AnimeData
import com.example.animelistcompose.ui.components.TrendingAnimeItem


@Composable
fun TrendingAnimeScreen(state: TrendingAnimeListState) {
    val trendingAnimeList = state.trendingAnimeList
    
    Scaffold() { innerPadding->
        AnimatedContent(targetState = state.isLoading ,label="") {isLoading->
            if(isLoading){
                Box(modifier =Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    CircularProgressIndicator()
                }
            }
            else{
                TrendingAnimeList(list = trendingAnimeList, innerPaddingValues = innerPadding)
            }
        }
    }
    
}

@Composable
fun TrendingAnimeList(list:List<AnimeData>,innerPaddingValues: PaddingValues){
    LazyColumn (verticalArrangement = Arrangement.spacedBy(16.dp), contentPadding = PaddingValues(
        start = 12.dp,
        end = 12.dp,
        top = 12.dp+innerPaddingValues.calculateTopPadding(),
        bottom = 8.dp+innerPaddingValues.calculateBottomPadding()
    )){
        item {
            Text(text="Trending Animes", fontSize = 32.sp, fontWeight = FontWeight.Medium)
        }
        items(list){
            TrendingAnimeItem(animeData = it, modifier = Modifier.fillMaxWidth()) {

            }
        }
    }
}