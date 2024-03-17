package com.movieviewer.core.data.di

import com.movieviewer.core.data.repository.AuthRepositoryImpl
import com.movieviewer.core.data.repository.MovieListRepositoryImpl
import com.movieviewer.core.domain.repository.AuthRepository
import com.movieviewer.core.domain.repository.MovieListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

    @Binds
    fun bindsAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl,
    ): AuthRepository

    @Binds
    fun bindsMovieListRepository(
        movieListRepositoryImpl: MovieListRepositoryImpl,
    ): MovieListRepository
}
