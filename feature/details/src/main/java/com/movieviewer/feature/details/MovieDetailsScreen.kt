package com.movieviewer.feature.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.movieviewer.core.common.currency
import com.movieviewer.core.common.imagePath
import com.movieviewer.core.domain.model.details.MovieDetail
import com.movieviewer.core.navigation.AppComposeNavigator
import com.movieviewer.designsystem.theme.MovieViewerTheme

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp)
                .verticalScroll(state = rememberScrollState()),
        ) {
            movieDetails.value?.let {
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
                            color = MovieViewerTheme.colors.movieDetails.title,
                            style = MovieViewerTheme.fonts.movieDetails.title
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
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "Overview",
                    color = MovieViewerTheme.colors.movieDetails.title,
                    style = MovieViewerTheme.fonts.movieDetails.title
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = it.overview ?: "",
                    color = Color.Black,
                )
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "Top Billed Cast",
                    color = MovieViewerTheme.colors.movieDetails.title,
                    style = MovieViewerTheme.fonts.movieDetails.title
                )
//                Spacer(Modifier.height( = 10f)
//                CreditsList(onClickPeople = onClickPeople)
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "Videos",
                    color = MovieViewerTheme.colors.movieDetails.title,
                    style = MovieViewerTheme.fonts.movieDetails.title
                )
//                Spacer(Modifier.height( = 10f)
//                TrailerList(onClickTrailer = onClickTrailer)
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "Recommendations",
                    color = MovieViewerTheme.colors.movieDetails.title,
                    style = MovieViewerTheme.fonts.movieDetails.title
                )
//                Spacer(Modifier.height(10.dp))
//                RecommendationsItemList( onClickMovie = onClickMovie )
                Spacer(Modifier.height(30.dp))
                Text(
                    text = "Status",
                    color = Color.Black,
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = it.status,
                    color = Color.Black,
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Original Language",
                    color = Color.Black,
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = it.originalLanguage,
                    color = Color.Black,
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Budget",
                    color = Color.Black,
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = it.budget.currency(),
                    color = Color.Black,
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "Revenue",
                    color = Color.Black,
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = it.revenue.currency(),
                    color = Color.Black,
                )
            }
            Spacer(Modifier.height(50.dp))
        }
    }
}
