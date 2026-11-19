package com.robby.movieapplication.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author Robby Tan
 */
@Serializable
data class Movie(
    val id: Int,
    val cover: String,
    @SerialName("judul") val title: String,
    @SerialName("deskripsi") val description: String,
    @SerialName("pemeran_utama") val mainActor: String,
    @SerialName("pemeran_pendamping") val sideActor: String? = null
)