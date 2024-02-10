package ru.myster1o.kinoapp.features.popular.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.myster1o.kinoapp.core.data.network.BaseResponse
import ru.myster1o.kinoapp.features.popular.domain.models.MovieModel
import ru.myster1o.kinoapp.features.popular.domain.repository.KinopoiskRepository
import javax.inject.Inject

class GetTopMoviesUseCase @Inject constructor(
  private val kinopoiskRepository: KinopoiskRepository
) {
  suspend operator fun invoke(): Flow<BaseResponse<List<MovieModel>>> = kinopoiskRepository.getTopMovies()
}