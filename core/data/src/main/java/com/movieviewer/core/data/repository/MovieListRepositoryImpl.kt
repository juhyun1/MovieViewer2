package com.movieviewer.core.data.repository

import com.movieviewer.core.network.model.MovieListResponse
import com.movieviewer.core.network.service.MovieListService
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieListService: MovieListService,
) : MovieListRepository {
    override suspend fun nowPlaying(
        region: String,
        language: String,
        page: Int,
    ): MovieListResponse {
        return movieListService.nowPlaying(
            region = region,
            language = language,
            page = page,
        )
    }
}