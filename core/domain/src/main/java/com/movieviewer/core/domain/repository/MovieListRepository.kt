package com.movieviewer.core.domain.repository

import com.movieviewer.core.domain.model.MovieListInfo

interface MovieListRepository {
    suspend fun nowPlaying(
        region: String = "KR",
        language: String = "ko_KR",
        page: Int = 1,
    ): MovieListInfo
}
