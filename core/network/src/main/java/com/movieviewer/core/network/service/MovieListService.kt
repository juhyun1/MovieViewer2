package com.movieviewer.core.network.service

import com.movieviewer.core.network.model.MovieDetailsResponse
import com.movieviewer.core.network.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieListService {
    @GET("movie/now_playing")
    suspend fun nowPlaying(
        @Query("region") region: String = "KR",
        @Query("language") language: String = "ko_KR",
        @Query("page") page: Int = 1,
    ): MovieListResponse

    @GET("movie/upcoming")
    suspend fun upComing(
        @Query("region") region: String = "KR",
        @Query("language") language: String = "ko_KR",
        @Query("page") page: Int = 1,
    ): MovieListResponse

    @GET("movie/{movie_id}")
    suspend fun details(
        @Path("movie_id") movie_id: Int,
        @Query("language") language: String = "ko_KR",
    ): MovieDetailsResponse
}

//region
// https://en.wikipedia.org/wiki/ISO_3166-1
