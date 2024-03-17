plugins {
    id("movie.android.library")
    id("movie.spotless")
    id("movie.android.hilt")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.movieviewer.core.common"
}

dependencies {
    api(libs.kotlinx.serialization)
    testImplementation(libs.junit)
}