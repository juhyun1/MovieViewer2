package com.movieviewer.core.domain.repository

import androidx.paging.PagingData
import com.movieviewer.core.domain.model.Movie
import com.movieviewer.core.domain.model.MovieListInfo
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    suspend fun nowPlaying(
        region: String = "KR",
        language: String = "ko_KR",
        page: Int = 1,
    ): MovieListInfo

    suspend fun upComing(
        region: String = "KR",
        language: String = "ko_KR",
        page: Int = 1,
    ): MovieListInfo

    suspend fun nowPlayingDataSource(): Flow<PagingData<Movie>>
    suspend fun upComingDataSource(): Flow<PagingData<Movie>>
}
