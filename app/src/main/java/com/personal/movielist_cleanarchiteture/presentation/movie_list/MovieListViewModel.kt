package com.personal.movielist_cleanarchiteture.presentation.movie_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.movielist_cleanarchiteture.common.Resource
import com.personal.movielist_cleanarchiteture.domain.model.MovieResponseModel
import com.personal.movielist_cleanarchiteture.domain.use_case.GetPopularMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(val getPopularMovies: GetPopularMovies): ViewModel() {

    private var _dataState: MutableLiveData<Resource<List<MovieResponseModel>>> = MutableLiveData()

    val dataState get() = _dataState

    fun setStateEvent(mainStateEvent: MainStateEvent) {
        when(mainStateEvent) {
            is MainStateEvent.GetBlogEvents -> {
                getMovies()
            }
            is MainStateEvent.None -> {

            }
        }
    }

    private fun getMovies() {
        getPopularMovies().map {
            _dataState.value = it
        }.launchIn(viewModelScope)
    }
}

sealed class MainStateEvent{
    object GetBlogEvents: MainStateEvent()
    object None: MainStateEvent()
}