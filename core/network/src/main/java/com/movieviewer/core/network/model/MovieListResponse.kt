package com.movieviewer.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse(
    val page: Int,
    val results: List<Movie>,
    val dates: Dates,
    val total_results: Int,
    val total_pages: Int,
)
