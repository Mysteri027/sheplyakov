package ru.myster1o.kinoapp.features.popular.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.myster1o.kinoapp.core.data.network.BaseResponse
import ru.myster1o.kinoapp.features.popular.data.network.KinopoiskApiService
import ru.myster1o.kinoapp.features.popular.domain.models.MovieModel
import ru.myster1o.kinoapp.features.popular.domain.repository.KinopoiskRepository
import javax.inject.Inject

class KinopoiskRepositoryImpl @Inject constructor(
  private val kinopoiskApiService: KinopoiskApiService,
): KinopoiskRepository {
  override suspend fun getTopMovies(): Flow<BaseResponse<List<MovieModel>>> = flow {
    val response = kinopoiskApiService.getTopMovies(type = "TOP_100_POPULAR_FILMS")

    if (response.isSuccessful) {
      response.body()?.let { movieDTOList ->
        emit(BaseResponse.Success(data = movieDTOList.map { movieDTO -> movieDTO.toDomain() }))
      }
    } else {
        emit(BaseResponse.Error(error = response.message()))
    }
  }

  override suspend fun getMovieDetails(id: Int): Flow<BaseResponse<MovieModel>> = flow {
    val response = kinopoiskApiService.getMovieDetails(id)

    if (response.isSuccessful) {
      response.body()?.let { movieDTO ->
        emit(BaseResponse.Success(data = movieDTO.toDomain()))
      }
    } else {
      emit(BaseResponse.Error(error = response.message()))
    }
  }
}