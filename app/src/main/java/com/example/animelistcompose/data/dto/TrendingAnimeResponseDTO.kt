package com.example.animelistcompose.data.dto

import com.example.animelistcompose.domain.models.Attributes
import com.example.animelistcompose.domain.models.CoverImage
import com.example.animelistcompose.domain.models.AnimeData
import com.example.animelistcompose.domain.models.PosterImage
import com.example.animelistcompose.domain.models.Titles
import com.example.animelistcompose.domain.models.TrendingAnimeList

data class TrendingAnimeResponseDTO(
    val data: List<DataDto>
) {
    fun toTrendingAnimeList():TrendingAnimeList{
        return TrendingAnimeList(data=data.map {
            it.toData()
        })
    }

}

data class DataDto(
    val attributes: AttributesDto,
    val id: String,
) {
    fun toData(): AnimeData {
       return AnimeData(attributes = attributes.toAttributes(),id=id)
    }
}

data class AttributesDto(
    val abbreviatedTitles: List<String>,
    val averageRating: String,
    val canonicalTitle: String,
    val coverImage: CoverImageDto,
    val description: String,
    val favoritesCount: Int,
    val popularityRank: Int,
    val posterImage: PosterImageDto,
    val showType: String,
    val startDate: String,
    val subtype: String?,
    val synopsis: String,
    val titles: TitlesDto,
    val totalLength: Int,
    val userCount: Int?,
) {
    fun toAttributes(): Attributes {
        return Attributes(
            abbreviatedTitles = abbreviatedTitles,
            averageRating = averageRating,
            canonicalTitle = canonicalTitle,
            coverImage = coverImage.toCoverImage(),
            description = description,
            favoritesCount = favoritesCount,
            popularityRank = popularityRank,
            synopsis = synopsis,
            showType = showType,
            startDate = startDate,
            titles = titles.toTitles(),
            userCount = userCount,
            totalLength = totalLength,
            posterImage = posterImage.toPosterImage(),
            subtype = subtype
        )
    }
}

data class CoverImageDto(
    val large: String,
    val original: String,
    val small: String,
    val tiny: String
) {
    fun toCoverImage(): CoverImage {
        return CoverImage(
            large = large,
            original = original,
            small = small,
            tiny = tiny
        )
    }
}

data class PosterImageDto(
    val large: String,
    val medium: String,
    val original: String,
    val small: String,
    val tiny: String
) {

    fun toPosterImage(): PosterImage {
        return PosterImage(
            large = large,
            medium = medium,
            original = original,
            small = small,
            tiny = tiny
        )
    }
}

data class TitlesDto(
    val en: String
) {

    fun toTitles(): Titles {
        return Titles(en = en)
    }

}
