package com.movieviewer.core.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request()
            .newBuilder()
            .addHeader(AUTHORIZATION, "$BEARER ${BuildConfig.Access_Token}")
            .build()
        return chain.proceed(newRequest)
    }
}

private const val AUTHORIZATION = "Authorization"
private const val BEARER = "Bearer"
