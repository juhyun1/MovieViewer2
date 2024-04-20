package com.movieviewer.feature.nowplaying

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.movieviewer.core.domain.model.Movie
import com.movieviewer.core.domain.usecase.MovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class NowPlayingViewModel @Inject constructor(
    private val movieListUseCase: MovieListUseCase,
) : ContainerHost<NowPlayingState, NowPlayingSideEffect>, ViewModel() {
    override val container = container<NowPlayingState, NowPlayingSideEffect>(NowPlayingState())

    private val _nowPlayingState: MutableStateFlow<PagingData<Movie>> = MutableStateFlow(value = PagingData.empty())
    val nowPlayingState: MutableStateFlow<PagingData<Movie>> get() = _nowPlayingState

    fun fetchNowPlayingList() {
        intent {
            viewModelScope.launch {
                movieListUseCase
                    .nowPlayingList()
                    .cachedIn(viewModelScope)
                    .collect {
                        _nowPlayingState.value = it
                    }
            }
        }
    }
}

data class NowPlayingState(
    val pagingData: PagingData<Movie> = PagingData.empty(),
)

sealed class NowPlayingSideEffect {
}
