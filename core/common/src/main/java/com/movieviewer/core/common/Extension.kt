package com.movieviewer.core.common

fun String.imagePath(): String = "https://image.tmdb.org/t/p/w500$this"
fun String.thumbnailPath() = "https://img.youtube.com/vi/$this/sddefault.jpg"
