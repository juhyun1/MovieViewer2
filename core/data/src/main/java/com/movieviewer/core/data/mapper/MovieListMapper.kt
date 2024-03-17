package com.movieviewer.core.data.mapper

import android.text.TextUtils
import com.movieviewer.core.domain.model.MovieListInfo
import com.movieviewer.core.domain.model.details.MovieDetail
import com.movieviewer.core.network.model.DatesDto
import com.movieviewer.core.network.model.Movie
import com.movieviewer.core.network.model.MovieDetailsResponse
import com.movieviewer.core.network.model.MovieListResponse
import com.movieviewer.core.domain.model.Dates as DomainDates
import com.movieviewer.core.domain.model.Movie as DomainMovie
fun MovieListResponse.asDomain(): MovieListInfo {
    return MovieListInfo(
        page = page,
        results = results.map { it.asDomain() },
        dates = dates?.asDomain(),
        totalResults = total_results,
        totalPages = total_pages,
    )
}

fun Movie.asDomain(): DomainMovie {
    return DomainMovie(
        posterPath = poster_path ?: "",
        adult = adult,
        overview = overview ?: "",
        releaseDate = release_date ?: "",
        genreIds = genre_ids,
        id = id,
        originalTitle = original_title ?: "",
        originalLanguage = original_language ?: "",
        title = title,
        backdropPath = backdrop_path ?: "",
        popularity = popularity,
        voteCount = vote_count,
        video = video,
        voteAverage = vote_average,
    )
}

fun DatesDto.asDomain(): DomainDates {
    return DomainDates(
        maximum = maximum,
        minimum = minimum,
    )
}

fun MovieDetailsResponse.asDomain(): MovieDetail {
    val list = ArrayList<String>()
    for (genres in this.genres) {
        list.add(genres.name)
    }
    val genres = TextUtils.join(",", list)

    return MovieDetail(
        revenue = this.revenue,
        budget = this.budget,
        originalLanguage = this.original_language,
        status = this.status,
        overview = this.overview,
        tagline = this.tagline,
        genres = genres,
        voteAverage = this.vote_average,
        runtime = this.runtime,
        releaseDate = this.release_date,
        title = this.title,
        backdropImage = this.backdrop_path,
        posterImage = this.poster_path,
    )
}
