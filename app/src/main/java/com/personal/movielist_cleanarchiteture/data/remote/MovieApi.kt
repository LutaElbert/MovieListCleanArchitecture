package com.personal.movielist_cleanarchiteture.data.remote

import android.graphics.Bitmap
import com.personal.movielist_cleanarchiteture.data.remote.dto.ResultResponseDto

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("3/discover/movie")
    suspend fun getPopularMovies(
        @Query("sort_by")
        description:String,
        @Query("api_key")
        apiKey: String
    ): ResultResponseDto

    @GET("t/p/original/{path}")
    suspend fun getPathImage(@Path("path")path: String): Bitmap

}