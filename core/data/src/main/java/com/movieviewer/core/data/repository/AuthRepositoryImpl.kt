package com.movieviewer.core.data.repository

import com.movieviewer.core.data.mapper.asDomain
import com.movieviewer.core.domain.model.AccessToken
import com.movieviewer.core.domain.model.RequestToken
import com.movieviewer.core.domain.repository.AuthRepository
import com.movieviewer.core.network.service.AuthService
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authService: AuthService,
) : AuthRepository {
    override suspend fun createAccessToken(): AccessToken {
        return authService.accessToken().asDomain()
    }
    override suspend fun createRequestToken(): RequestToken {
        return authService.requestToken().asDomain()
    }
}
