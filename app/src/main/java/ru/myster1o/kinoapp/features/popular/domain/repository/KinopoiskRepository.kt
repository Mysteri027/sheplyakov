package ru.myster1o.kinoapp.features.popular.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.myster1o.kinoapp.core.data.network.BaseResponse
import ru.myster1o.kinoapp.features.popular.domain.models.MovieModel

interface KinopoiskRepository {

  suspend fun getTopMovies(): Flow<BaseResponse<List<MovieModel>>>
  suspend fun getMovieDetails(id: Int): Flow<BaseResponse<MovieModel>>
}