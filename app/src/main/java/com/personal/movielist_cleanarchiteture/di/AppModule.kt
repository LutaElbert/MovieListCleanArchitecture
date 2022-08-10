package com.personal.movielist_cleanarchiteture.di

import com.personal.movielist_cleanarchiteture.common.Constants
import com.personal.movielist_cleanarchiteture.data.remote.MovieApi
import com.personal.movielist_cleanarchiteture.data.repository.MovieRepositoryImpl
import com.personal.movielist_cleanarchiteture.domain.repository.IMovieRepository
import com.personal.movielist_cleanarchiteture.domain.use_case.GetPopularMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMovieApi(): MovieApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun providesMovieRepository(movieApi: MovieApi): IMovieRepository = MovieRepositoryImpl(movieApi)

    @Provides
    fun providesGetPopularMovies(repository: IMovieRepository) = GetPopularMovies(repository)
}