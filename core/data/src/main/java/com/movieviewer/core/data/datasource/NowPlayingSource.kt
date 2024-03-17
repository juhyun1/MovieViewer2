package com.movieviewer.core.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.movieviewer.core.domain.model.Movie
import com.movieviewer.core.domain.repository.MovieListRepository
import retrofit2.HttpException
import java.io.IOException

class NowPlayingSource(
    val movieListRepository: MovieListRepository,
) : PagingSource<Int, Movie>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val currentPage = params.key ?: 1
            val movies = movieListRepository.nowPlaying(page = currentPage)
            LoadResult.Page(
                data = movies.results,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (movies.results.isEmpty()) null else movies.page + 1,
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }
}
