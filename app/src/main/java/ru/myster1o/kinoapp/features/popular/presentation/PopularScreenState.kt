package ru.myster1o.kinoapp.features.popular.presentation

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import ru.myster1o.kinoapp.features.popular.presentation.models.MovieUIModel

data class PopularScreenState(
  val filmList: ImmutableList<MovieUIModel> = persistentListOf(),
  val loadingState: LoadingState = LoadingState.Idle,

)

enum class LoadingState {
  Idle, Loading, NotFound, ConnectionError, Content
}