package ru.myster1o.kinoapp.features.popular.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.myster1o.kinoapp.features.popular.data.network.KinopoiskApiService
import ru.myster1o.kinoapp.features.popular.data.repository.KinopoiskRepositoryImpl
import ru.myster1o.kinoapp.features.popular.domain.repository.KinopoiskRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PopularMoviesModule {

  @Provides
  @Singleton
  fun provideKinopoiskRepository(kinopoiskApiService: KinopoiskApiService) : KinopoiskRepository {
    return KinopoiskRepositoryImpl(kinopoiskApiService)
  }
}