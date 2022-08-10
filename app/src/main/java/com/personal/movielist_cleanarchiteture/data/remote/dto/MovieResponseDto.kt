package com.personal.movielist_cleanarchiteture.data.remote.dto

import com.personal.movielist_cleanarchiteture.domain.model.MovieResponseModel
import com.personal.movielist_cleanarchiteture.presentation.movie_list.MovieListViewModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponseDto(
    val id: Int,
    @field:Json(name = "original_title")
    val originalTitle: String,
    val overview: String,
    @field:Json(name = "poster_path")
    val posterPath: String,
    @field:Json(name = "release_date")
    val releaseDate: String,
    @field:Json(name = "vote_average")
    val voteAverage: Double
)

fun MovieResponseDto.toMovieResponse(): MovieResponseModel {
    return MovieResponseModel(id, originalTitle, overview, posterPath, releaseDate, voteAverage)
}