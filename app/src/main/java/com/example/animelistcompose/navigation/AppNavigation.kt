package com.example.animelistcompose.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.animelistcompose.presentation.anime.AnimeDetailsScreen
import com.example.animelistcompose.presentation.trendingAnime.TrendingAnimeListViewmodel
import com.example.animelistcompose.presentation.trendingAnime.TrendingAnimeScreen
import com.example.animelistcompose.ui.components.TrendingAnimeItem


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    SharedTransitionLayout {

        NavHost(navController = navController, startDestination = TrendingAnimeListRoute) {
            composable<TrendingAnimeListRoute> {
                val viewmodel: TrendingAnimeListViewmodel = hiltViewModel()
                val state by viewmodel.state.collectAsStateWithLifecycle()
                TrendingAnimeScreen(state = state, animatedVisibilityScope = this){
                    navController.navigate(AnimeItemRoute(id=it.id,coverImage = it.attributes.coverImage.original))
                }
            }

            composable<AnimeItemRoute> {
                val args = it.toRoute<AnimeItemRoute>()
                AnimeDetailsScreen(id = args.id, coverImage = args.coverImage, animatedVisibilityScope = this)
            }
        }
    }
}