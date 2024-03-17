package com.movieviewer.feature.upcoming.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.movieviewer.core.navigation.AppComposeNavigator
import com.movieviewer.core.navigation.Screens
import com.movieviewer.feature.upcoming.UpComingScreen

fun NavGraphBuilder.upComingScreen(
    composeNavigator: AppComposeNavigator,
) {
    composable(
        route = Screens.UpComing.name,
    ) {
        UpComingScreen(composeNavigator = composeNavigator)
    }
}
