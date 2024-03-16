package com.movieviewer.core.data.repository

import com.movieviewer.core.network.model.AccessToken
import com.movieviewer.core.network.model.RequestToken
import com.movieviewer.core.network.service.AuthService
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService,
) : AuthRepository {
    override suspend fun createAccessToken(): AccessToken = authService.accessToken()
    override suspend fun createRequestToken(): RequestToken = authService.requestToken()
}
