package com.movieviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.movieviewer.ui.theme.MovieViewerTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
//        splashScreen.setKeepOnScreenCondition { true }
        viewModel.createAccessToken()
        setContent {
            MovieViewerTheme {
                val list = viewModel.test.collectAsState(initial = null)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    list.value?.let {
                        Timber.v("asdf: $list")
                        LazyColumn {
                            items(it.results) { movie ->
                                Row {
                                    Text(
                                        text = "${movie.title}: ",
                                        color = Color.Black,
                                    )
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Text(
                                        text = movie.release_date,
                                        color = Color.Black,
                                    )
//                                    Spacer(modifier = Modifier.width(3.dp))
//                                    Text(text = movie.overview)
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}
