package com.aqua_tech.gads2020.ui.main.di

import com.aqua_tech.gads2020.BuildConfig
import com.aqua_tech.gads2020.api.GADSAPIService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
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
            .addConverterFactory(GsonConverterFactory.create(gson))
//            .addCallAdapterFactory(LiveDataCallAdapterFactory()) // Gets called first
            .build().create(GADSAPIService::class.java)
    }
}