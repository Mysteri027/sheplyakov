package ru.myster1o.kinoapp.core.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import dagger.hilt.android.AndroidEntryPoint
import ru.myster1o.kinoapp.core.ui.theme.KinoappTheme
import ru.myster1o.kinoapp.features.popular.presentation.PopularViewModel
import ru.myster1o.kinoapp.features.popular.presentation.components.PopularScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  private val popularViewModel: PopularViewModel by viewModels()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {

      val uiState by popularViewModel.uiState.collectAsState()

      KinoappTheme {
        PopularScreen(
          uiState = uiState,
          onLaunch = remember {
            {
              popularViewModel.getTopMovies()
            }
          }
        )
      }
    }
  }
}
