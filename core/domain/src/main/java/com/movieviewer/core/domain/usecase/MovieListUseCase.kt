package com.movieviewer.core.domain.usecase

import androidx.paging.PagingData
import com.movieviewer.core.domain.model.Movie
import com.movieviewer.core.domain.repository.MovieListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieListUseCase @Inject constructor(
    private val repository: MovieListRepository,
) {
    suspend fun nowPlayingList(): Flow<PagingData<Movie>> {
        return repository.nowPlayingDataSource()
    }

    suspend fun upComingList(): Flow<PagingData<Movie>> {
        return repository.upComingDataSource()
    }
}
