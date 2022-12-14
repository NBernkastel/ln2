package com.bern.ln2.di

import com.bern.ln2.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    const val BASE_URL = "https://api.tvmaze.com/shows/"
    @Provides
    @Singleton
    fun providerRetrofit() : ApiService =
        Retrofit.Builder().baseUrl(BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)
}