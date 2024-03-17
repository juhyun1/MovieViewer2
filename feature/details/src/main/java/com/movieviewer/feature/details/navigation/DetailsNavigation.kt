package com.movieviewer.feature.details.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.movieviewer.core.navigation.AppComposeNavigator
import com.movieviewer.core.navigation.Screens
import com.movieviewer.core.navigation.Screens.Companion.argument_selection
import com.movieviewer.feature.details.MovieDetailsScreen

fun NavGraphBuilder.movieDetailsScreen(
    composeNavigator: AppComposeNavigator,
) {
    composable(
        route = Screens.MovieDetails.name,
    ) {
        val arguments = it.arguments?.getString(argument_selection) ?: return@composable
        val movieId: Int = arguments.toInt()

        MovieDetailsScreen(composeNavigator = composeNavigator, movieId = movieId)
    }
}
