package com.movieviewer.designsystem.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Stable
data class FontTokens(
    val movieCard: MovieCardTokens = MovieCardTokens(),
)

val LocalMovieViewerFonts = staticCompositionLocalOf<FontTokens> {
    error("No FontTokens provided")
}

data class MovieCardTokens(
    val title: TextStyle = TextStyle(
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
    ),
    val releaseDate: TextStyle = TextStyle(
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
    ),
)
