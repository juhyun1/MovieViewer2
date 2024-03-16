package com.movieviewer.feature.nowplaying

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import timber.log.Timber

@Composable
fun NowPlayingScreen(
    viewModel: NowPlayingViewModel = hiltViewModel()
) {
    val list = viewModel.test.collectAsState(initial = null)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        LaunchedEffect(key1 = Unit) {
            viewModel.fetchNowPlayingList()
        }

        list.value?.let {
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