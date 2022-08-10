package com.personal.movielist_cleanarchiteture.presentation.movie_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import com.personal.movielist_cleanarchiteture.R
import com.personal.movielist_cleanarchiteture.common.Resource
import com.personal.movielist_cleanarchiteture.databinding.FragmentMovieListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment : Fragment() {

    private var _binding: FragmentMovieListBinding? = null

    private val binding get() = _binding!!

    val viewModel: MovieListViewModel by hiltNavGraphViewModels(R.id.navigation_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)

        subscribeObserver()
        viewModel.setStateEvent(MainStateEvent.GetBlogEvents)

        return binding.root
    }

    private fun subscribeObserver() {
        viewModel.dataState.observe(viewLifecycleOwner) { dataState ->
            when(dataState) {
                is Resource.Success -> {
                    Log.d("qwe", "subscribeObserver Success: ${dataState.data}")
                }
                is Resource.Error -> {
                    Log.d("qwe", "subscribeObserver Error: ")
                }
                is Resource.Loading -> {
                    Log.d("qwe", "subscribeObserver Loading: ")
                }
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}