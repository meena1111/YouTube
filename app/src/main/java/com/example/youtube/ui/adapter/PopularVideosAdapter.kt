package com.example.youtube.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.youtube.base.BaseDiffUtilItemCallback
import com.example.youtube.databinding.ItemPopularVideosBinding
import com.example.youtube.models.VideoItem
import com.example.youtube.models.VideoItemSnippet

class PopularVideosAdapter :
    ListAdapter<VideoItem, PopularVideosAdapter.PopularVideoViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularVideoViewHolder =
        PopularVideoViewHolder(
            ItemPopularVideosBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: PopularVideoViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it.snippet) }
    }

    class PopularVideoViewHolder(private val binding: ItemPopularVideosBinding) :
        ViewHolder(binding.root) {
        fun onBind(model: VideoItemSnippet) {
            binding.tvTittleVideo.text = model.tittle
            binding.ivVideosItem.load(model.thumbnails.image.url)
        }
    }
}