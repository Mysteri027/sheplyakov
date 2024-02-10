package ru.myster1o.kinoapp.features.popular.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import ru.myster1o.kinoapp.R
import ru.myster1o.kinoapp.core.ui.theme.KinoappTheme
import ru.myster1o.kinoapp.features.popular.presentation.models.MovieUIModel

@Composable
fun MovieItem(
  movieUIModel: MovieUIModel,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier
      .clip(RoundedCornerShape(15.dp))
      .fillMaxWidth(),
    colors = CardDefaults.cardColors(containerColor = Color.White)
  ) {
    Row(
      modifier = Modifier.padding(start = 15.dp)
    ) {
      AsyncImage(
        modifier = Modifier
          .clip(RoundedCornerShape(5.dp))
          .padding(top = 15.dp, bottom = 15.dp)
          .size(width = 40.dp, height = 63.dp),
        model = movieUIModel.posterUrl,
        placeholder = painterResource(R.drawable.ic_preview_placeholder),
        contentDescription = "Movie Item"
      )
      Column(modifier = Modifier.padding(start = 15.dp, top = 26.dp)) {
        Text(
          text = movieUIModel.title,
          color = Color.Black,
          fontSize = 16.sp,

        )

        Text(
          modifier = Modifier.padding(top = 8.dp),
          text = "${movieUIModel.genre} (${movieUIModel.year})",
          fontSize = 14.sp,
          color = Color.Black.copy(alpha = 0.6f),
          fontWeight = FontWeight(500),
          fontFamily = FontFamily.Default,
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
  KinoappTheme {
    MovieItem(
      movieUIModel = MovieUIModel(
        posterUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
        posterPreviewUrl = "https://avatars.mds.yandex.net/get-kinopoisk-image/4774061/cf1970bc-3f08-4e0e-a095-2fb57c3aa7c6/360",
        title = "Целкунчик",
        year = "2022",
        genre = "Фэнтези",
      )
    )
  }
}