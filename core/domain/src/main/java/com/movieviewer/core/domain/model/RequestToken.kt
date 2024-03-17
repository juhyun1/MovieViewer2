package com.movieviewer.core.domain.model

data class RequestToken(
    val statusMessage: String,
    val requestToken: String,
    val success: Boolean,
    val statusCode: Int,
)
