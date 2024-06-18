package com.example.animelistcompose.presentation.anime

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.animelistcompose.domain.models.AnimeData
import com.example.animelistcompose.domain.models.CoverImage

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.AnimeDetailsScreen(
    id: Int, coverImage: String?,
    animatedVisibilityScope: AnimatedVisibilityScope,
    animeViewModel: AnimeViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {
        animeViewModel.getAnimeById(id)
    }

    val state by animeViewModel.animeState.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = innerPadding.calculateBottomPadding() + 8.dp)
        ) {

            item {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(coverImage).build(),
                    contentDescription = "Image Anime",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                        .sharedElement(
                            rememberSharedContentState(key = id),
                            animatedVisibilityScope = animatedVisibilityScope
                        ),
                    contentScale = ContentScale.Crop
                )
            }

            if (animeViewModel.animeState.value.animeData != null) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = state.animeData?.attributes?.canonicalTitle ?: "",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Row(horizontalArrangement = Arrangement.Center) {
                            Text(text = state.animeData?.attributes?.startDate ?: "" + "  -")
                            Icon(imageVector = Icons.Rounded.Star, contentDescription = "Rating")
                            Text(text = state.animeData?.attributes?.averageRating ?: "")
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(12.dp))
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Text(text = "Synopsis", fontWeight = FontWeight.SemiBold, fontSize = 22.sp)
                        Text(text = state.animeData?.attributes?.synopsis ?: "", fontSize = 12.sp)
                    }
                }


            }
        }
    }

}