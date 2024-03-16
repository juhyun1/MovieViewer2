package com.movieviewer.core.network

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class AuthAuthenticator @Inject constructor() : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        TODO("Not yet implemented")
    }

    private fun newRequestWithToken(token: String, request: Request): Request = request.newBuilder()
        .addHeader("Authorization", "Bearar $token")
        .build()
}
