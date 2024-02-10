package ru.myster1o.kinoapp.features.popular.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.myster1o.kinoapp.features.popular.data.dto.MovieDTO

interface KinopoiskApiService {
  @GET("/api/v2.2/films/top")
  suspend fun getTopMovies(@Query("type") type: String) : Response<List<MovieDTO>>

  @GET("/api/v2.2/films/top/{id}")
  suspend fun getMovieDetails(@Path("id") id: Int): Response<MovieDTO>
}