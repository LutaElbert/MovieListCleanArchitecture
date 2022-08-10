package com.personal.movielist_cleanarchiteture.data.repository

import com.personal.movielist_cleanarchiteture.data.remote.MovieApi
import com.personal.movielist_cleanarchiteture.data.remote.dto.ResultResponseDto
import com.personal.movielist_cleanarchiteture.domain.repository.IMovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi
): IMovieRepository {
    override suspend fun get(description: String, apiKey: String): ResultResponseDto {
        return api.getPopularMovies(description, apiKey)
    }
}