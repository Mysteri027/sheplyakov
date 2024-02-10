package ru.myster1o.kinoapp.features.popular.domain.usecases

import kotlinx.coroutines.flow.Flow
import ru.myster1o.kinoapp.core.data.network.BaseResponse
import ru.myster1o.kinoapp.features.popular.domain.models.MovieModel
import ru.myster1o.kinoapp.features.popular.domain.repository.KinopoiskRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
  private val kinopoiskRepository: KinopoiskRepository
) {

  suspend operator fun invoke(id: Int): Flow<BaseResponse<MovieModel>> = kinopoiskRepository.getMovieDetails(id)
}