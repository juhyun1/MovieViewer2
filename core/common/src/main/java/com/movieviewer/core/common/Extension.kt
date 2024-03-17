package com.movieviewer.core.common

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun String.imagePath(): String = "https://image.tmdb.org/t/p/w500$this"
fun String.thumbnailPath() = "https://img.youtube.com/vi/$this/sddefault.jpg"

inline fun <reified T : Any> encodeToString(value: T): String {
    return Json.encodeToString(value)
}
inline fun <reified T> String.decodeFromString(): T {
    return Json.decodeFromString(this)
}
