package com.movieviewer.initializer

import android.content.Context
import androidx.startup.Initializer

class MainInitializer : Initializer<Unit> {

    override fun create(context: Context) = Unit

    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(
        LogInitializer::class.java,
    )
}
