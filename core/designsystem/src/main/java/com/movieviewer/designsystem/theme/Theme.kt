package com.movieviewer.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember

@Composable
fun MovieViewerTheme(
    content: @Composable () -> Unit,
) {
    ProvideMovieViewerColors(ColorTokens()) {
        ProvideMovieViewerFonts(FontTokens()) {
            MaterialTheme(
                content = content,
            )
        }
    }
}

object MovieViewerTheme {
    val colors: ColorTokens
        @Composable
        get() = LocalMovieViewerColor.current

    val fonts: FontTokens
        @Composable
        get() = LocalMovieViewerFonts.current
}

@Composable
fun ProvideMovieViewerColors(
    colors: ColorTokens,
    content: @Composable () -> Unit,
) {
    val colorPalette = remember {
        colors.copy()
    }
    CompositionLocalProvider(LocalMovieViewerColor provides colorPalette, content = content)
}

@Composable
fun ProvideMovieViewerFonts(
    fonts: FontTokens,
    content: @Composable () -> Unit,
) {
    val typography = remember {
        fonts.copy()
    }
    CompositionLocalProvider(LocalMovieViewerFonts provides typography, content = content)
}
