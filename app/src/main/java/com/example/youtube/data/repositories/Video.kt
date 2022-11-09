package com.example.youtube.data.repositories

import com.example.youtube.base.BaseRepository
import com.example.youtube.data.remote.apiservices.VideoApiServices
import javax.inject.Inject

class VideoRepository @Inject constructor(private val services: VideoApiServices): BaseRepository() {
    fun fetchVideos(part: String, chart: String, maxResults: Int) = doRequest {
        services.fetchVideos(part, chart, maxResults)
    }
}