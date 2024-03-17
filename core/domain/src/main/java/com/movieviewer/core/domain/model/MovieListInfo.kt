package com.movieviewer.core.domain.model

data class MovieListInfo(
    val page: Int,
    val results: List<Movie>,
    val dates: Dates,
    val totalResults: Int,
    val totalPages: Int,
)