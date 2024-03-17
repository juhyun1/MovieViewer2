package com.movieviewer.feature.upcoming

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.movieviewer.core.domain.model.Movie
import com.movieviewer.core.domain.usecase.MovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpComingViewModel @Inject constructor(
    private val movieListUseCase: MovieListUseCase,
) : ViewModel() {
    private val _upComingState: MutableStateFlow<PagingData<Movie>> = MutableStateFlow(value = PagingData.empty())
    val upComingState: MutableStateFlow<PagingData<Movie>> get() = _upComingState

    fun fetchUpcomingList() {
        viewModelScope.launch {
            movieListUseCase
                .upComingList()
                .cachedIn(viewModelScope)
                .collect {
                    _upComingState.value = it
                }
        }
    }
}
