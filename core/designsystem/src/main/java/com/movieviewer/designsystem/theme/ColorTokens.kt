package com.movieviewer.designsystem.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
data class ColorTokens(
    val movieCard: MovieCard = MovieCard(),
)

val LocalMovieViewerColor = staticCompositionLocalOf<ColorTokens> {
    error("No ColorTokens provided")
}

data class MovieCard(
    val background: Color = White,
    val rate: Color = Green8,
    val title: Color = Black,
    val releaseDate: Color = Grey3,
)

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Brown = Color(0xFF673d31)
val Brown2 = Color(0xa6673d31)

val White = Color(0xFFFFFFFF)
val White2 = Color(0xFFf9f9f9)

val Red = Color(0xFFff0000)
val Red2 = Color(0xFFff2800)
val Red3 = Color(0xFFff4f5c)

val Green = Color(0xFF00a757)
val Green2 = Color(0xFF0C8B6F)
val Green3 = Color(0xFF00f37f)
val Green4 = Color(0xFF14e945)
val Green5 = Color(0xFF05f115)
val Green6 = Color(0xFF33ff00)
val Green7 = Color(0xFF4cd964)
val Green8 = Color(0xFF204529)

val Yellow = Color(0xFFf4c529)
val Yellow2 = Color(0xFFfac131)
val Yellow3 = Color(0xFFffd630)
val Yellow4 = Color(0xFFffdf00)
val Yellow5 = Color(0xFFfbbe16)
val Yellow6 = Color(0xFFbf791a)
val Yellow7 = Color(0xFFf3bb2f)

val Black = Color(0xFF000000)

val Blue = Color(0xFF056bf1)
val Blue2 = Color(0xFF3187fa)
val Blue3 = Color(0xFF3699e7)

val GreenPlaceOrder = Color(0xFF4cd964)
val Grey1 = Color(0xFF707070)
val Grey2 = Color(0xfff6f6f6)
val Grey3 = Color(0xff969696)
val Grey4 = Color(0xffc7c7c7)
val Grey5 = Color(0xFF767676)
val Grey6 = Color(0xFF5a5a5a)
val Grey7 = Color(0xFFe8e8e8)
val Grey8 = Color(0xFFa0a0a0)
val Grey9 = Color(0xFFbfbfbf)
val Grey10 = Color(0xFFc5c5c5)
val Grey11 = Color(0xFF616161)
val Grey12 = Color(0xFFe4e4e4)
