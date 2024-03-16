plugins {
    id("movie.android.library")
    id("movie.android.library.compose")
    id("movie.spotless")
}

android {
    namespace = "com.movieviewer.core.designsystem"
}

dependencies {

    val bom = libs.androidx.compose.bom
    api(platform(bom))
    debugApi(platform(bom))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.timber)

    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.util)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    1
    api(libs.junit)
    api(libs.espresso.core)
    api(libs.androidx.test.ext.junit)
    debugApi(libs.androidx.compose.ui.tooling)

    api(libs.coil.kt.compose)
}