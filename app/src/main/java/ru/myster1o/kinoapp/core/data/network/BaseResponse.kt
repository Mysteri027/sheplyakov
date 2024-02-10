package ru.myster1o.kinoapp.core.data.network

sealed class BaseResponse<T> {
  data class Success<T>(val data: T) : BaseResponse<T>()
  data class Error<T>(val error: String) : BaseResponse<T>()
}