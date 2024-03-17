package com.movieviewer.core.data.repository

import com.movieviewer.core.data.mapper.asDomain
import com.movieviewer.core.domain.model.details.MovieDetail
import com.movieviewer.core.domain.repository.MovieDetailsRepository
import com.movieviewer.core.network.service.MovieListService
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val movieListService: MovieListService,
) : MovieDetailsRepository {
    override suspend fun movieDetails(movieId: Int, language: String): MovieDetail {
        return movieListService.details(movie_id = movieId, language = language).asDomain()
    }
}
