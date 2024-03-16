plugins {
    id("movie.android.library")
    id("movie.spotless")
    id("movie.android.hilt")
    id("org.jetbrains.kotlin.plugin.serialization")
    id(libs.plugins.google.secrets.get().pluginId)
}

android {
    namespace = "com.movieviewer.core.network"
}

secrets {
    propertiesFileName = "secrets.properties"
    defaultPropertiesFileName = "secrets.defaults.properties"
    ignoreList.add("keyToIgnore") // Ignore the key "keyToIgnore"
    ignoreList.add("sdk.*") // Ignore all keys matching the regexp "sdk.*"
}

dependencies {
    api(projects.core.domain)
    api(projects.core.common)

    api(libs.okhttp.logging)
    api(libs.retrofit.core)
    testImplementation(libs.junit)
}