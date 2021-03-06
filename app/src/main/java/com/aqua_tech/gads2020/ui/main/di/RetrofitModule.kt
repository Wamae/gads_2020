package com.aqua_tech.gads2020.ui.main.di

import com.aqua_tech.gads2020.BuildConfig
import com.aqua_tech.gads2020.api.GADSAPIService
import com.aqua_tech.gads2020.api.GoogleFormAPIService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RetrofitModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideFERPAPIService( gson: Gson): GADSAPIService {

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(getGoogleFormHttpClient().build())
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addCallAdapterFactory(LiveDataCallAdapterFactory()) // Gets called first
            .build().create(GADSAPIService::class.java)
    }

    @Singleton
    @Provides
    fun provideGoogleFormAPIService(): GoogleFormAPIService {

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(getGadsHttpClient().build())
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addCallAdapterFactory(LiveDataCallAdapterFactory()) // Gets called first
            .build().create(GoogleFormAPIService::class.java)
    }

    private fun getGadsHttpClient(): OkHttpClient.Builder {

        val loggingInterceptor = getHttpLoggingInterceptor()

        val httpClient = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) httpClient.addInterceptor(loggingInterceptor)

        return httpClient
    }

    private fun getGoogleFormHttpClient(): OkHttpClient.Builder {

        val loggingInterceptor = getHttpLoggingInterceptor()

        val httpClient = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) httpClient.addInterceptor(loggingInterceptor)

        return httpClient
    }

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }
}