package com.fatemehmsp.data.network

import com.fatemehmsp.data.BuildConfig
import com.fatemehmsp.data.network.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .callTimeout(CALL_TIME_OUT_IN_MILLIS, TimeUnit.MILLISECONDS)
            .connectTimeout(CONNECT_TIME_OUT_IN_MILLIS, TimeUnit.MILLISECONDS)
            .readTimeout(READ_TIME_OUT_IN_MILLIS, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIME_OUT_IN_MILLIS, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(  HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                }
            ).addInterceptor { chain ->
                val url = chain.request().newBuilder()
                    .header(AUTHORIZATION, API_KEY)
                    .build()
                chain.proceed(url)
            }.build()


    @Provides
    @Singleton
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()


    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit): ApiService = retrofit.create()

    companion object {
        private const val CALL_TIME_OUT_IN_MILLIS = 15000L
        private const val CONNECT_TIME_OUT_IN_MILLIS = 10000L
        private const val READ_TIME_OUT_IN_MILLIS = 30000L
        private const val WRITE_TIME_OUT_IN_MILLIS = 30000L

        private const val BASE_URL = "https://api.github.com/"

        private const val AUTHORIZATION = "Authorization"
        private const val API_KEY = "Bearer <your api key>"
    }
}