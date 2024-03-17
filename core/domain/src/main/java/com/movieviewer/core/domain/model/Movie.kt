package com.movieviewer.core.domain.model

data class Movie(
    val posterPath: String,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalTitle: String,
    val originalLanguage: String,
    val title: String,
    val backdropPath: String,
    val popularity: Float,
    val voteCount: Int,
    val video: Boolean,
    val voteAverage: Float,

) {
    fun compareTo(movie: Movie): Int {
        return if (this.releaseDate.isEmpty()) {
            -1
        } else if (movie.releaseDate.isEmpty()) {
            1
        } else {
            val b = movie.releaseDate.substringBefore("-", movie.releaseDate).toInt()
            releaseDate.substringBefore("-", releaseDate).toInt().compareTo(b) * -1
        }
    }
}
