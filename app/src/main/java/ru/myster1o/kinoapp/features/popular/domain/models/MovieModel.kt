package ru.myster1o.kinoapp.features.popular.domain.models

data class MovieModel(
  val posterPreviewUrl: String,
  val posterUrl: String,
  val title: String,
  val year: String,
  val genre: String,
)