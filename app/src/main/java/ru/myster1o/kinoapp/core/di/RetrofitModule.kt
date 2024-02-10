package ru.myster1o.kinoapp.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.myster1o.kinoapp.features.popular.data.network.KinopoiskApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

  @Provides
  fun provideBaseUrl(): String = "https://kinopoiskapiunofficial.tech"

  @Provides
  fun provideApiKey(): String = "e30ffed0-76ab-4dd6-b41f-4c9da2b2735b"


  @Provides
  @Singleton
  fun provideRetrofit(baseUrl: String): Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(baseUrl)
    .build()

  @Provides
  @Singleton
  fun provideKinopoiskApi(retrofit: Retrofit): KinopoiskApiService = retrofit.create(KinopoiskApiService::class.java)
}