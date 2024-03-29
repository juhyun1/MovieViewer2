
package com.movieviewer.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieSpokenLanguagesDto(
    val iso_639_1: String,
    val name: String,
)

@Serializable
data class MovieProductionCountriesDto(
    val iso_3166_1: String,
    val name: String,
)

@Serializable
data class MovieProductionCompaniesDto(
    val name: String,
    val id: Int,
    val logo_path: String?,
    val origin_country: String,
)

@Serializable
data class MovieGenresDto(
    val id: Int,
    val name: String,
)

@Serializable
data class DatesDto(
    val maximum: String,
    val minimum: String,
)
