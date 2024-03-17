package com.movieviewer.feature.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.movieviewer.core.common.imagePath
import com.movieviewer.core.domain.model.details.MovieDetail
import com.movieviewer.core.navigation.AppComposeNavigator

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel = hiltViewModel(),
    composeNavigator: AppComposeNavigator,
    movieId: Int,
) {
    val movieDetails: State<MovieDetail?> = viewModel.movieDetailState.collectAsStateWithLifecycle()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        LaunchedEffect(key1 = Unit) {
            viewModel.fetchMovieDetails(movieId = movieId)
        }

        movieDetails.value?.let {
            LazyColumn {
                item {
                    Row {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(it.posterImage?.imagePath())
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.placeholder),
                            contentDescription = null,
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .size(width = 150.dp, height = 230.dp)
                                .clip(RoundedCornerShape(10.dp)),
                        )
                        Spacer(Modifier.width(10.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text(
                                text = it.title,
                                color = Color.Black,
                            )
                            Text(
                                text = it.releaseDate,
                                color = Color.Black,
                            )
                            Spacer(Modifier.height(20.dp))
                            Text(
                                text = it.tagline ?: "",
                                color = Color.Black,
                            )
                        }
                    }
                }
            }
        }
    }
}
