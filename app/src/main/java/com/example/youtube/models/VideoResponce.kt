package com.example.youtube.models

import com.example.youtube.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("nextPageToken")
    val nextPage: String,
    @SerializedName("prevPageToken")
    val prevPage: String,
    @SerializedName("items")
    val item: List<VideoItem>
)

data class VideoItem(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("id")
    override val id: String,
    @SerializedName("snippet")
    val snippet: VideoItemSnippet
): IBaseDiffModel<String>

data class VideoItemSnippet(
    @SerializedName("title")
    val tittle: String,
    @SerializedName("thumbnails")
    val thumbnails: ThumbnailImage
)

data class ThumbnailImage(
    @SerializedName("maxres")
    val image: VideoImage
)

data class VideoImage(
    @SerializedName("url")
    val url: String
)