package com.movieviewer.feature.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieviewer.core.domain.model.details.MovieDetail
import com.movieviewer.core.domain.usecase.MovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: MovieDetailsUseCase,
) : ViewModel() {
    private val _movieDetailState = MutableStateFlow<MovieDetail?>(null)
    val movieDetailState: StateFlow<MovieDetail?>
        get() = _movieDetailState

    fun fetchMovieDetails(movieId: Int) {
        viewModelScope.launch {
            _movieDetailState.value = movieDetailsUseCase.movieDetails(movieId = movieId)
        }
    }
}
