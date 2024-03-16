package com.movieviewer.core.common

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val dispatchers: MovieDispatchers)

enum class MovieDispatchers {
    Default,
    IO,
}
