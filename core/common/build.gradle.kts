plugins {
    id("movie.android.library")
    id("movie.spotless")
    id("movie.android.hilt")
}

android {
    namespace = "com.movieviewer.core.common"
}

dependencies {

    testImplementation(libs.junit)
}