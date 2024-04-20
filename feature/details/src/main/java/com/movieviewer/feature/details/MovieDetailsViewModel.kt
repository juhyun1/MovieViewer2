package com.movieviewer.feature.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieviewer.core.domain.model.UiState
import com.movieviewer.core.domain.model.details.MovieDetail
import com.movieviewer.core.domain.usecase.MovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: MovieDetailsUseCase,
) : ContainerHost<DetailsState, DetailsSideEffect>, ViewModel() {
    override val container = container<DetailsState, DetailsSideEffect>(DetailsState())

    fun fetchMovieDetails(movieId: Int) {
        intent {
            viewModelScope.launch {
                runCatching {
                    movieDetailsUseCase.movieDetails(movieId = movieId)
                }
                    .onFailure {
                        reduce {
                            state.copy(
                                status = UiState.Error,
                                movieDetail = null
                            )
                        }
                    }
                    .onSuccess {
                        reduce {
                            state.copy(
                                status = UiState.Idle,
                                movieDetail = it
                            )
                        }
                    }
            }
        }

    }
}

data class DetailsState(
    val status: UiState = UiState.Loading,
    val movieDetail: MovieDetail? = null,
)

sealed class DetailsSideEffect {
    data class Back(val id: Int) : DetailsSideEffect()
}
