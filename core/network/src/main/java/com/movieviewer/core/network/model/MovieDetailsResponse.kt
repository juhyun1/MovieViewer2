package com.movieviewer.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsResponse(
    val adult: Boolean = false,
    val backdrop_path: String? = null,
    val budget: Int = 0,
    val genres: List<MovieGenresDto> = emptyList(),
    val homepage: String? = null,
    val id: Int = 0,
    val imdb_id: String? = "",
    val original_language: String = "",
    val original_title: String = "",
    val overview: String? = null,
    val popularity: Float? = null,
    val poster_path: String? = "",
    val production_companies: List<MovieProductionCompaniesDto> = emptyList(),
    val production_countries: List<MovieProductionCountriesDto> = emptyList(),
    val release_date: String = "",
    val revenue: Long = 0,
    val runtime: Int? = null,
    val spoken_languages: List<MovieSpokenLanguagesDto> = emptyList(),
    val status: String = "",
    val tagline: String? = null,
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Float = 0f,
    val vote_count: Int = 0,
)
