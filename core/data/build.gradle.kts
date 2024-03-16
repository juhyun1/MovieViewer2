plugins {
    id("movie.android.library")
    id("movie.spotless")
    id("movie.android.hilt")
}

android {
    namespace = "com.movieviewer.core.data"
}

dependencies {
    api(project(":core:domain"))
    api(project(":core:network"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
}