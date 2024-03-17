package com.movieviewer.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.movieviewer.core.data.datasource.NowPlayingSource
import com.movieviewer.core.data.datasource.UpComingSource
import com.movieviewer.core.data.mapper.asDomain
import com.movieviewer.core.domain.model.Movie
import com.movieviewer.core.domain.model.MovieListInfo
import com.movieviewer.core.domain.repository.MovieListRepository
import com.movieviewer.core.network.service.MovieListService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieListService: MovieListService,
) : MovieListRepository {
    override suspend fun nowPlaying(
        region: String,
        language: String,
        page: Int,
    ): MovieListInfo {
        return movieListService.nowPlaying(region = region, language = language, page = page).asDomain()
    }

    override suspend fun upComing(
        region: String,
        language: String,
        page: Int,
    ): MovieListInfo {
        return movieListService.upComing(region = region, language = language, page = page).asDomain()
    }

    override suspend fun nowPlayingDataSource(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 2,
                enablePlaceholders = true,
                maxSize = 1000,
            ),
            pagingSourceFactory = {
                NowPlayingSource(movieListRepository = this)
            },
        ).flow
    }

    override suspend fun upComingDataSource(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 2,
                enablePlaceholders = true,
                maxSize = 1000,
            ),
            pagingSourceFactory = {
                UpComingSource(movieListRepository = this)
            },
        ).flow
    }
}
