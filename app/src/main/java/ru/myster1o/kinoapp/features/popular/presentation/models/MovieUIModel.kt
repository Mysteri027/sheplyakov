package ru.myster1o.kinoapp.features.popular.presentation.models

import ru.myster1o.kinoapp.features.popular.domain.models.MovieModel

data class MovieUIModel(
  val posterPreviewUrl: String,
  val posterUrl: String,
  val title: String,
  val year: String,
  val genre: String,
)

fun MovieModel.toPresentation() = MovieUIModel(
  posterPreviewUrl = posterPreviewUrl,
  posterUrl = posterUrl,
  title = title,
  year = year,
  genre = genre,
)