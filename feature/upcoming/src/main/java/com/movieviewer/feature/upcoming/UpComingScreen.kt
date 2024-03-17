package com.movieviewer.feature.upcoming

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.movieviewer.core.common.imagePath
import com.movieviewer.core.domain.model.Movie
import com.movieviewer.core.navigation.AppComposeNavigator
import com.movieviewer.core.navigation.Screens
import com.movieviewer.designsystem.theme.MovieViewerTheme

@Composable
fun UpComingScreen(
    viewModel: UpComingViewModel = hiltViewModel(),
    composeNavigator: AppComposeNavigator,
) {
    val moviePagingItems: LazyPagingItems<Movie> =
        viewModel.upComingState.collectAsLazyPagingItems()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        LaunchedEffect(key1 = Unit) {
            viewModel.fetchUpcomingList()
        }

        LazyVerticalGrid(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            columns = GridCells.Fixed(2),
        ) {
            items(moviePagingItems.itemCount) {
                val movie = moviePagingItems[it]
                movie?.let {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                composeNavigator.navigate(
                                    route = Screens.MovieDetails.createRoute(
                                        movieId = it.id,
                                    ),
                                )
                            },
                        colors = CardDefaults.cardColors(containerColor = MovieViewerTheme.colors.movieCard.background),
                        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
                    ) {
                        BoxWithConstraints {
                            val maxWidth = this.maxWidth
                            Column {
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(movie.posterPath.imagePath())
                                        .crossfade(true)
                                        .build(),
                                    placeholder = painterResource(R.drawable.placeholder),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(maxWidth * (270.dp / 180.dp)),
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Column(
                                    modifier = Modifier
                                        .padding(horizontal = 15.dp)
                                        .height(70.dp),
                                ) {
                                    Text(
                                        text = movie.title,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis,
                                        style = MovieViewerTheme.fonts.movieCard.title,
                                        color = MovieViewerTheme.colors.movieCard.title,
                                    )
                                    Spacer(modifier = Modifier.height(5.dp))
                                    Text(
                                        text = movie.releaseDate,
                                        style = MovieViewerTheme.fonts.movieCard.releaseDate,
                                        color = MovieViewerTheme.colors.movieCard.releaseDate,
                                    )
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                            Box(
                                modifier = Modifier
                                    .padding(start = 10.dp, bottom = 85.dp)
                                    .size(30.dp)
                                    .clip(CircleShape)
                                    .background(color = MovieViewerTheme.colors.movieCard.rate)
                                    .align(alignment = Alignment.BottomStart),
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(
                                    text = (movie.voteAverage * 10).toInt().toString(),
                                    color = Color.White,
                                    textAlign = TextAlign.Center,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
