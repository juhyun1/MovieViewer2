package com.movieviewer.core.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.movieviewer.core.network.AuthAuthenticator
import com.movieviewer.core.network.AuthorizationInterceptor
import com.movieviewer.core.network.BuildConfig
import com.movieviewer.core.network.service.AuthService
import com.movieviewer.core.network.service.MovieListService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        authorizationInterceptor: AuthorizationInterceptor,
        authAuthenticator: AuthAuthenticator,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .apply {
                this.addInterceptor(authorizationInterceptor)
                this.authenticator(authAuthenticator)
                this.addInterceptor(
                    HttpLoggingInterceptor()
                        .apply {
                            if (BuildConfig.DEBUG) {
                                setLevel(HttpLoggingInterceptor.Level.BODY)
                            }
                        },
                )
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        networkJson: Json,
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(V3_BASE_URL)
            .callFactory(okHttpClient)
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType()),
            )
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit,
    ): AuthService {
        return retrofit.create()
    }

    @Provides
    @Singleton
    fun provideMovieListService(
        retrofit: Retrofit,
    ): MovieListService {
        return retrofit.create()
    }
}

private const val BASE_URL = "https://api.themoviedb.org/4/"
private const val V3_BASE_URL = "https://api.themoviedb.org/3/"
