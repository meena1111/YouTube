package com.example.youtube.data.remote.apiservices

import com.example.youtube.models.VideoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoApiServices {

    @GET("videos")
    suspend fun fetchVideos(
        @Query("part") part: String,
        @Query("chart") chart: String,
        @Query("maxResults") maxResults: Int
    ): Response<VideoResponse>
}