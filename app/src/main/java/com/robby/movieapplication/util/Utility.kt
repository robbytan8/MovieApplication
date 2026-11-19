package com.robby.movieapplication.util

import android.content.Context
import com.robby.movieapplication.entity.Movie
import kotlinx.serialization.json.Json

/**
 * @author Robby Tan
 */
object Utility {
  fun readJsonFile(context: Context, fileName: String): List<Movie> {
    val jsonData = context.assets.open(fileName).bufferedReader().use { it.readText() }
    val json = Json { ignoreUnknownKeys = true }
    return json.decodeFromString(jsonData)
  }

  fun readJsonSingleMovie(context: Context, fileName: String): Movie {
    val jsonData = context.assets.open(fileName).bufferedReader().use { it.readText() }
    val json = Json { ignoreUnknownKeys = true }
    return json.decodeFromString(jsonData)
  }
}