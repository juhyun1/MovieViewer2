@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("movie.android.application")
    id("movie.android.application.compose")
    id("movie.android.hilt")
    id("movie.spotless")
    id(libs.plugins.google.secrets.get().pluginId)
}

android {
    namespace = "com.movieviewer"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.movieviewer"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.androidxComposeCompiler.get()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

secrets {
    propertiesFileName = "secrets.properties"
    defaultPropertiesFileName = "secrets.defaults.properties"
    ignoreList.add("keyToIgnore") // Ignore the key "keyToIgnore"
    ignoreList.add("sdk.*") // Ignore all keys matching the regexp "sdk.*"
}

dependencies {

    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.core.network)
    implementation(projects.core.common)
    implementation(projects.core.designsystem)
    implementation(projects.feature.nowplaying)

    // material
    implementation(libs.androidx.appcompat)

    // compose
    implementation(libs.androidx.activity.compose)

    // jetpack
    implementation(libs.androidx.startup)

    implementation(libs.androidx.core.splashscreen)

    // logger
    implementation(libs.timber)

    //coroutine
    implementation(libs.kotlinx.coroutines.android)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
}
