plugins {
    id("movie.android.library")
    id("movie.spotless")
    id("movie.android.hilt")
}

android {
    namespace = "com.movieviewer.core.navigation"
}

dependencies {

    api(project(":core:domain"))

    api(libs.androidx.navigation.compose)
}