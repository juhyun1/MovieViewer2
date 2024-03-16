plugins {
    id("movie.android.library")
    id("movie.spotless")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.movieviewer.core.domain"
}

dependencies {

    api(libs.retrofit.kotlin.serialization)
    api(libs.kotlinx.serialization)
    testImplementation(libs.junit)
}