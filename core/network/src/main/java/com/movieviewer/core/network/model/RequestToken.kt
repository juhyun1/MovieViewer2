package com.movieviewer.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class RequestToken(
    val status_message: String,
    val request_token: String,
    val success: Boolean,
    val status_code: Int,
)
