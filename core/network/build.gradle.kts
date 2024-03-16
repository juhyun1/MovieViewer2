plugins {
    id("movie.android.library")
    id("movie.spotless")
    id("movie.android.hilt")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.movieviewer.core.network"
}

dependencies {
    implementation(project(":core:domain"))

    api(libs.okhttp.logging)
    api(libs.retrofit.core)

    api(libs.retrofit.kotlin.serialization)
    api(libs.kotlinx.serialization)

    testImplementation(libs.junit)
}