package com.movieviewer.core.domain.model

sealed class UiState {
    data object Loading : UiState()
    data object Idle : UiState()
    data object Error : UiState()
}