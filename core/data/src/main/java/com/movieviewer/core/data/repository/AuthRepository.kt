package com.movieviewer.core.data.repository

import com.movieviewer.core.network.model.AccessToken
import com.movieviewer.core.network.model.RequestToken

interface AuthRepository {
    suspend fun createAccessToken(): AccessToken
    suspend fun createRequestToken(): RequestToken
}
