package com.movieviewer.core.domain.repository

import com.movieviewer.core.domain.model.AccessToken
import com.movieviewer.core.domain.model.RequestToken

interface AuthRepository {
    suspend fun createAccessToken(): AccessToken
    suspend fun createRequestToken(): RequestToken
}
