package com.movieviewer.core.data.repository

import com.movieviewer.core.data.mapper.asDomain
import com.movieviewer.core.domain.model.MovieListInfo
import com.movieviewer.core.domain.repository.MovieListRepository
import com.movieviewer.core.network.service.MovieListService
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieListService: MovieListService,
) : MovieListRepository {
    override suspend fun nowPlaying(
        region: String,
        language: String,
        page: Int,
    ): MovieListInfo {
        return movieListService.nowPlaying(
            region = region,
            language = language,
            page = page,
        ).asDomain()
    }
}
