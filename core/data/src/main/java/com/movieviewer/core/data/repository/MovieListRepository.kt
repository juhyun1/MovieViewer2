package com.movieviewer.core.data.repository

import com.movieviewer.core.network.model.MovieListResponse

interface MovieListRepository {
    suspend fun nowPlaying(
        region: String = "KR",
        language: String = "ko_KR",
        page: Int = 1,
    ): MovieListResponse
}
