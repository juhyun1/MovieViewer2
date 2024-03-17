package com.movieviewer.core.domain.repository

import com.movieviewer.core.domain.model.details.MovieDetail

interface MovieDetailsRepository {
    suspend fun movieDetails(
        movieId: Int,
        language: String = "ko_KR",
    ): MovieDetail
}
