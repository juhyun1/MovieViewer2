package com.movieviewer.core.domain.model

data class AccessToken(
    val accountId: String,
    val accessToken: String,
    val success: Boolean,
    val statusMessage: String,
    val statusCode: Int,
)
