package com.movieviewer.core.data.mapper

import com.movieviewer.core.network.model.AccessToken
import com.movieviewer.core.network.model.RequestToken
import com.movieviewer.core.domain.model.AccessToken as DomainAccessToken
import com.movieviewer.core.domain.model.RequestToken as DomainRequestToken
fun AccessToken.asDomain(): DomainAccessToken {
    return DomainAccessToken(
        accountId = account_id,
        accessToken = access_token,
        success = success,
        statusMessage = status_message,
        statusCode = status_code,
    )
}

fun RequestToken.asDomain(): DomainRequestToken {
    return DomainRequestToken(
        statusMessage = status_message,
        requestToken = request_token,
        success = success,
        statusCode = status_code,
    )
}
