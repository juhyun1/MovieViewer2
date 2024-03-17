package com.movieviewer.core.data.mapper

import com.movieviewer.core.domain.model.MovieListInfo
import com.movieviewer.core.network.model.Dates
import com.movieviewer.core.network.model.Movie
import com.movieviewer.core.network.model.MovieListResponse
import com.movieviewer.core.domain.model.Dates as DomainDates
import com.movieviewer.core.domain.model.Movie as DomainMovie
fun MovieListResponse.asDomain(): MovieListInfo {
    return MovieListInfo(
        page = page,
        results = results.map { it.asDomain() },
        dates = dates.asDomain(),
        totalResults = total_results,
        totalPages = total_pages,
    )
}

fun Movie.asDomain(): DomainMovie {
    return DomainMovie(
        posterPath = poster_path,
        adult = adult,
        overview = overview,
        releaseDate = release_date,
        genreIds = genre_ids,
        id = id,
        originalTitle = original_title,
        originalLanguage = original_language,
        title = title,
        backdropPath = backdrop_path,
        popularity = popularity,
        voteCount = vote_count,
        video = video,
        voteAverage = vote_average,
    )
}

fun Dates.asDomain(): DomainDates {
    return DomainDates(
        maximum = maximum,
        minimum = minimum,
    )
}
