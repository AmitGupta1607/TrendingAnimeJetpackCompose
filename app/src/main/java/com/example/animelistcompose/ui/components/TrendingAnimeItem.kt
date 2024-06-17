package com.example.animelistcompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.animelistcompose.domain.models.AnimeData
import com.example.animelistcompose.ui.theme.PurpleLight


@Composable
fun TrendingAnimeItem(animeData: AnimeData, modifier: Modifier, onClick: (AnimeData) -> Unit) {
    Card(modifier = modifier.clickable {
        onClick(animeData)
    }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            val requestItem = ImageRequest.Builder(LocalContext.current)
                .data(animeData.attributes.posterImage.original).build()
            AsyncImage(
                model = requestItem,
                contentDescription = "Anime Image",
                modifier = Modifier
                    .size(100.dp)
                    .clip(
                        RoundedCornerShape(8.dp)
                    ),
                contentScale = ContentScale.Crop
            )
            Column {
                Row(
                    modifier = Modifier
                        .padding(vertical = 4.dp, horizontal = 2.dp)
                        .background(
                            color = PurpleLight,
                            shape = RoundedCornerShape(32.dp)
                        )
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = "Rating",
                        tint = Color.Yellow
                    )
                    Text(text = animeData.attributes.averageRating, fontSize = 14.sp,modifier=Modifier.padding(end=8.dp))
                }
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = animeData.attributes.canonicalTitle,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp
                )
                Text(
                    text = animeData.attributes.synopsis,
                    fontSize = 11.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }


    }
}