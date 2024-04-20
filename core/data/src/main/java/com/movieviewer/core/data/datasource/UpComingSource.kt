package com.movieviewer.core.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.movieviewer.core.domain.model.Movie
import com.movieviewer.core.domain.repository.MovieListRepository

class UpComingSource(
    private val movieListRepository: MovieListRepository,
) : PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage = params.key ?: 1
            val movies = movieListRepository.upComing(page = currentPage)
            LoadResult.Page(
                data = movies.results,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (movies.results.isEmpty()) null else movies.page + 1,
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}
