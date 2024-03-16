package com.movieviewer.initializer

import android.content.Context
import androidx.startup.Initializer
import timber.log.Timber

class LogInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
