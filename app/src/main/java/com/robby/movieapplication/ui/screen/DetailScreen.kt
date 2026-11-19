package com.robby.movieapplication.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.robby.movieapplication.entity.Movie

/**
 * @author Robby Tan
 */
@Composable
fun DetailScreen(movie: Movie, modifier: Modifier = Modifier) {
  Column(
    modifier = modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Center,
  ) {
    ItemRow("Title", movie.title)
    ItemRow("Description", movie.description)
    ItemRow("Main Actor", movie.mainActor)
    movie.sideActor?.let { ItemRow("Side Actor", it) }
  }
}

@Composable
fun ItemRow(label: String, data: String) {
  Row(horizontalArrangement = Arrangement.SpaceBetween) {
    Text(
      label, style = MaterialTheme.typography.bodyMedium,
      color = MaterialTheme.colorScheme.onSurfaceVariant,
      modifier = Modifier
        .weight(0.30f)
        .padding(end = 12.dp)
    )
    Text(
      data, style = MaterialTheme.typography.bodyMedium,
      fontWeight = FontWeight.SemiBold,
      color = MaterialTheme.colorScheme.onSurface,
      textAlign = TextAlign.Start,
      modifier = Modifier.weight(0.70f)
    )
  }
}