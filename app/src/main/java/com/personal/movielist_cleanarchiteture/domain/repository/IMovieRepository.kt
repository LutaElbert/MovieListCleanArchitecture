package com.personal.movielist_cleanarchiteture.domain.repository

import com.personal.movielist_cleanarchiteture.data.remote.dto.ResultResponseDto

interface IMovieRepository {

    suspend fun get(description: String, apiKey: String): ResultResponseDto

}