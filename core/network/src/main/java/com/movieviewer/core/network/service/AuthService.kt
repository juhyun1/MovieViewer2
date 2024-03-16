package com.movieviewer.core.network.service

import com.movieviewer.core.network.model.AccessToken
import com.movieviewer.core.network.model.RequestToken
import retrofit2.http.POST

interface AuthService {

    @POST("auth/access_token")
    suspend fun accessToken(): AccessToken

    @POST("auth/request_token")
    suspend fun requestToken(): RequestToken
}
