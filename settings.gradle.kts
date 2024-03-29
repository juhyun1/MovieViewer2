@file:Suppress("UnstableApiUsage")
pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://plugins.gradle.org/m2/")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "MovieViewer"
include(":app")
include(":core:data")
include(":core:datastore")
include(":core:domain")
include(":core:network")
include(":core:common")
include(":core:navigation")
include(":core:designsystem")
include(":feature:nowplaying")
include(":feature:upcoming")
include(":feature:details")
