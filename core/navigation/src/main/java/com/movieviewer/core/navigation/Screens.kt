package com.movieviewer.core.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screens(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList(),
) {
    val name: String = route.appendArguments(navArguments)

    data object NowPlaying : Screens(route = "NowPlaying")
    data object UpComing : Screens(route = "UpComing")

    data object MovieDetails : Screens(
        route = "MovieDetails",
        navArguments = listOf(navArgument(argument_selection) { type = NavType.StringType }),
    ) {
        fun createRoute(movieId: Int) = name.replace("{${navArguments.first().name}}", movieId.toString())
    }
    companion object {
        const val argument_selection = "selection"
    }
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}
