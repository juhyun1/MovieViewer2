package com.movieviewer.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class AccessToken(
    val account_id: String,
    val access_token: String,
    val success: Boolean,
    val status_message: String,
    val status_code: Int,
)
