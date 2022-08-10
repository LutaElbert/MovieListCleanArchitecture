package com.personal.movielist_cleanarchiteture.domain.use_case

import com.personal.movielist_cleanarchiteture.BuildConfig
import com.personal.movielist_cleanarchiteture.common.Constants
import com.personal.movielist_cleanarchiteture.common.Resource
import com.personal.movielist_cleanarchiteture.data.remote.dto.toMovieList
import com.personal.movielist_cleanarchiteture.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPopularMovies @Inject constructor(private val repository: IMovieRepository) {

    operator fun invoke() = flow {
        try{
            emit(Resource.Loading())
            val movies = repository.get(Constants.QUERY_DESCRIPTION, BuildConfig.API_KEY).toMovieList()
            emit(Resource.Success(movies))
        } catch(e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "GetPopularMovies: something is wrong"))
        }
    }

}