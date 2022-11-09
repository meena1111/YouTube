package com.example.youtube.ui.fragments

import com.example.youtube.base.BaseViewModel
import com.example.youtube.data.repositories.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularVideosViewModel @Inject constructor(private val repository: VideoRepository) :
    BaseViewModel() {

    fun fetchPopularVideos() = repository.fetchVideos("snippet", "mostPopular", 50)
}