package com.example.animelistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.animelistcompose.presentation.trendingAnime.TrendingAnimeList
import com.example.animelistcompose.presentation.trendingAnime.TrendingAnimeListViewmodel
import com.example.animelistcompose.presentation.trendingAnime.TrendingAnimeScreen
import com.example.animelistcompose.ui.theme.AnimeListComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeListComposeTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
                    val viewmodel = hiltViewModel<TrendingAnimeListViewmodel>()
                    val state by viewmodel.state.collectAsStateWithLifecycle()
                    TrendingAnimeScreen(state = state)
//                }
            }
        }
    }
}

