package com.movieviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.movieviewer.core.navigation.AppComposeNavigator
import com.movieviewer.core.navigation.Screens
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
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            NavigationDrawerItem(
                                label = {
                                    Text("Now Playing")
                                },
                                selected = false,
                                onClick = {
                                    scope.launch {
                                        appComposeNavigator.navigate(route = Screens.NowPlaying.name)
                                        drawerState.close()
                                    }
                                },
                            )
                            NavigationDrawerItem(
                                label = {
                                    Text("Up Coming")
                                },
                                selected = false,
                                onClick = {
                                    scope.launch {
                                        appComposeNavigator.navigate(route = Screens.UpComing.name)
                                        drawerState.close()
                                    }
                                },
                            )
                        }
                    },
                ) {
                    Scaffold { contentPadding ->
                        Box(modifier = Modifier.padding(contentPadding)) {
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
        }
    }
}
