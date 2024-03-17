package com.movieviewer.feature.nowplaying

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.movieviewer.core.domain.model.Movie
import com.movieviewer.core.domain.repository.AuthRepository
import com.movieviewer.core.domain.usecase.MovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NowPlayingViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val movieListUseCase: MovieListUseCase,
) : ViewModel() {
    private val _moviesState: MutableStateFlow<PagingData<Movie>> = MutableStateFlow(value = PagingData.empty())
    val moviesState: MutableStateFlow<PagingData<Movie>> get() = _moviesState

    fun fetchNowPlayingList() {
        viewModelScope.launch {
            movieListUseCase
                .nowPlayingList()
                .cachedIn(viewModelScope)
                .collect {
                    _moviesState.value = it
                }
        }
    }
}
