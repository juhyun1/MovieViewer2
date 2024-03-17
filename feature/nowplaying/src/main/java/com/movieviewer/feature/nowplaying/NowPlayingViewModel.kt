package com.movieviewer.feature.nowplaying

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movieviewer.core.domain.model.MovieListInfo
import com.movieviewer.core.domain.repository.AuthRepository
import com.movieviewer.core.domain.repository.MovieListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class NowPlayingViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val movieListRepository: MovieListRepository,
) : ViewModel() {
    val test = MutableStateFlow<MovieListInfo?>(null)
    fun fetchNowPlayingList() {
        viewModelScope.launch {
            val result = runCatching {
                movieListRepository.nowPlaying()
            }
            result
                .onSuccess {
                    test.value = it
                }
                .onFailure {
                    Timber.v(it)
                }
        }
    }
}
