package com.example.animelistcompose.domain.models

data class TrendingAnimeList(
    val data: List<AnimeData>
)

data class AnimeResponse(
    val animeData: AnimeData
)

data class AnimeData(
    val attributes: Attributes,
    val id: Int,
)

data class Attributes(
    val abbreviatedTitles: List<String>,
    val averageRating: String,
    val canonicalTitle: String,
    val coverImage: CoverImage,
    val description: String,
    val favoritesCount: Int,
    val popularityRank: Int,
    val posterImage: PosterImage,
    val showType: String,
    val startDate: String,
    val subtype: String?,
    val synopsis: String,
    val titles: Titles,
    val totalLength: Int,
    val userCount: Int?,
)

data class CoverImage(
    val large: String,
    val original: String,
    val small: String,
    val tiny: String
)
data class PosterImage(
    val large: String,
    val medium: String,
    val original: String,
    val small: String,
    val tiny: String
)

data class Titles(
    val en: String?
)