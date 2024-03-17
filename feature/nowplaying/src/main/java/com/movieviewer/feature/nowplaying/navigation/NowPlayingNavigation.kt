package com.movieviewer.feature.nowplaying.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.movieviewer.core.navigation.AppComposeNavigator
import com.movieviewer.core.navigation.Screens
import com.movieviewer.feature.nowplaying.NowPlayingScreen

fun NavGraphBuilder.nowPlayingScreen(
    composeNavigator: AppComposeNavigator,
) {
    composable(
        route = Screens.NowPlaying.name,
    ) {
        NowPlayingScreen(composeNavigator = composeNavigator)
    }
}
