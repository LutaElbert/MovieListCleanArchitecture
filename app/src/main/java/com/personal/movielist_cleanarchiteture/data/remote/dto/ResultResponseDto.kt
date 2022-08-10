package com.personal.movielist_cleanarchiteture.data.remote.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultResponseDto(
    val results: List<MovieResponseDto>
)

fun ResultResponseDto.toMovieList() = this.results.map { it.toMovieResponse() }