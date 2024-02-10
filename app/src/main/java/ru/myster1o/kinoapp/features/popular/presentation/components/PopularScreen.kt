package ru.myster1o.kinoapp.features.popular.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.persistentListOf
import ru.myster1o.kinoapp.core.ui.theme.KinoappTheme
import ru.myster1o.kinoapp.features.popular.presentation.LoadingState
import ru.myster1o.kinoapp.features.popular.presentation.PopularScreenState
import ru.myster1o.kinoapp.features.popular.presentation.models.MovieUIModel

@Composable
fun PopularScreen(
  uiState: PopularScreenState,
  onLaunch: () -> Unit,
  modifier: Modifier = Modifier,
) {

  LaunchedEffect(key1 = uiState) {
    onLaunch()
  }

  when (uiState.loadingState) {
    LoadingState.Idle            -> {}
    LoadingState.Loading         -> {}
    LoadingState.NotFound        -> {}
    LoadingState.ConnectionError -> {}
    LoadingState.Content         -> {
      LazyColumn(
        modifier = modifier
      ) {
        items(uiState.filmList) {
          MovieItem(movieUIModel = it)
        }
      }
    }
  }
}

@Preview
@Composable
fun PopularScreenPreview() {
  KinoappTheme {
    PopularScreen(
      onLaunch = {},
      uiState = PopularScreenState(
        filmList = persistentListOf(
          MovieUIModel(
            posterPreviewUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            posterUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            title = "qwe",
            genre = "223",
            year = "2019"
          ),
          MovieUIModel(
            posterPreviewUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            posterUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            title = "qwe",
            genre = "223",
            year = "2019"
          ),
          MovieUIModel(
            posterPreviewUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            posterUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            title = "qwe",
            genre = "223",
            year = "2019"
          ),
          MovieUIModel(
            posterPreviewUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            posterUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            title = "qwe",
            genre = "223",
            year = "2019"
          ),
          MovieUIModel(
            posterPreviewUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            posterUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            title = "qwe",
            genre = "223",
            year = "2019"
          ),
          MovieUIModel(
            posterPreviewUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            posterUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            title = "qwe",
            genre = "223",
            year = "2019"
          ),
          MovieUIModel(
            posterPreviewUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            posterUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
            title = "qwe",
            genre = "223",
            year = "2019"
          ),
        )
      )
    )
  }
}