package com.movieviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.movieviewer.core.navigation.AppComposeNavigator
import com.movieviewer.designsystem.theme.MovieViewerTheme
import com.movieviewer.nagivation.MovieViewerNavHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var appComposeNavigator: AppComposeNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
//        splashScreen.setKeepOnScreenCondition { true }
        setContent {
            MovieViewerTheme {
                val navHostController = rememberNavController()

                LaunchedEffect(Unit) {
                    launch {
                        appComposeNavigator.handleNavigationCommands(navHostController)
                    }
                }

                MovieViewerNavHost(
                    navHostController = navHostController,
                    composeNavigator = appComposeNavigator,
                    finish = {
                        finishAffinity()
                    },
                )
            }
        }
    }
}
