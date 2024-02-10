package ru.myster1o.kinoapp.features.popular.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.myster1o.kinoapp.core.data.network.BaseResponse
import ru.myster1o.kinoapp.features.popular.domain.usecases.GetMovieDetailsUseCase
import ru.myster1o.kinoapp.features.popular.domain.usecases.GetTopMoviesUseCase
import ru.myster1o.kinoapp.features.popular.presentation.models.toPresentation
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
  private val getTopMoviesUseCase: GetTopMoviesUseCase,
  private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
) : ViewModel() {

  private val _uiState: MutableStateFlow<PopularScreenState> = MutableStateFlow(PopularScreenState())
  val uiState: StateFlow<PopularScreenState> = _uiState.asStateFlow()


  fun getTopMovies() {

    _uiState.value = _uiState.value.copy(loadingState = LoadingState.Loading)

    viewModelScope.launch {
      getTopMoviesUseCase().collect { response ->
        when (response) {
          is BaseResponse.Error   -> {

          }

          is BaseResponse.Success -> {
            _uiState.value =
              _uiState.value.copy(loadingState = LoadingState.Content, filmList = response.data.map { it.toPresentation() }.toImmutableList())
          }
        }
      }
    }
  }

}