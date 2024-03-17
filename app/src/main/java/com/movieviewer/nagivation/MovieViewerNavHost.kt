package com.movieviewer.nagivation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.movieviewer.core.navigation.AppComposeNavigator
import com.movieviewer.core.navigation.Screens
import com.movieviewer.feature.nowplaying.navigation.nowPlayingScreen
import com.movieviewer.feature.upcoming.navigation.upComingScreen

@Composable
fun MovieViewerNavHost(
    navHostController: NavHostController,
    composeNavigator: AppComposeNavigator,
    finish: () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.NowPlaying.name,
    ) {
        nowPlayingScreen(composeNavigator = composeNavigator)
        upComingScreen(composeNavigator = composeNavigator)
    }
}
