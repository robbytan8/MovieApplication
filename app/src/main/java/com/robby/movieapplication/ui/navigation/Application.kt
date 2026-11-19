package com.robby.movieapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.robby.movieapplication.ui.screen.DetailScreen
import com.robby.movieapplication.ui.screen.MainScreen
import com.robby.movieapplication.util.Utility

/**
 * @author Robby Tan
 */
object Route {
  const val HOME = "home"
  const val DETAIL = "detail/{id}"
  fun detail(id: Int): String {
    return "detail/${id}"
  }
}

@Composable
fun Application(modifier: Modifier = Modifier) {
  val navController = rememberNavController()
  val context = LocalContext.current
  val movies = remember { Utility.readJsonFile(context, "data_film.json") }

  NavHost(navController, Route.HOME) {
    composable(Route.HOME) {
      MainScreen(movies, navController, modifier)
    }
    composable(Route.DETAIL, arguments = listOf(navArgument("id") { type = NavType.IntType })) {
      val movieId = it.arguments?.getInt("id") ?: 1
      val movie = Utility.readJsonSingleMovie(context, "${movieId}.json")
      DetailScreen(movie, modifier)
    }
  }
}