package com.robby.movieapplication.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.robby.movieapplication.entity.Movie
import com.robby.movieapplication.ui.navigation.Route

/**
 * @author Robby Tan
 */
@Composable
fun MainScreen(movies: List<Movie>, navController: NavController, modifier: Modifier = Modifier) {
  LazyColumn(
    modifier = modifier.fillMaxSize()
  ) {
    items(movies) { movie ->
      MovieCard(movie, { navController.navigate(Route.detail(movie.id)) })
    }
  }
}

@Composable
fun MovieCard(movie: Movie, onClickAction: () -> Unit) {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(8.dp),
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.primaryContainer,
      contentColor = MaterialTheme.colorScheme.onSurface
    ),
    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
    onClick = onClickAction
  ) {
    Column(
      modifier = Modifier.padding(8.dp)
    ) {
      Text(
        "${movie.title} (${movie.id})",
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
      )
      Text(
        movie.description,
        fontStyle = FontStyle.Italic,
        fontSize = 14.sp
      )
    }
  }
}