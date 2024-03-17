package com.movieviewer.core.domain.usecase

import com.movieviewer.core.domain.model.details.MovieDetail
import com.movieviewer.core.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class MovieDetailsUseCase @Inject constructor(
    private val movieDetailsRepository: MovieDetailsRepository,
) {
    suspend fun movieDetails(
        movieId: Int,
        language: String = "ko_KR",
    ): MovieDetail {
        return movieDetailsRepository.movieDetails(
            movieId = movieId,
            language = language,
        )
    }
}
