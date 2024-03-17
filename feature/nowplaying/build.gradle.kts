plugins {
    id("movie.android.library")
    id("movie.android.library.compose")
    id("movie.android.hilt")
    id("movie.android.feature")
    id("movie.spotless")
}

android {
    namespace = "com.movieviewer.feature.nowplaying"
}

dependencies {
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)
}