package com.movieviewer.core.navigation.di

import com.movieviewer.core.navigation.AppComposeNavigator
import com.movieviewer.core.navigation.MovieViewerNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun provideNavigator(
        marketNavigator: MovieViewerNavigator,
    ): AppComposeNavigator
}
