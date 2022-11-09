package com.example.youtube.ui.fragments

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.common.Resource
import com.example.youtube.databinding.FragmentPopularVideosBinding
import com.example.youtube.ui.adapters.PopularVideosAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularVideosFragment :
    BaseFragment<FragmentPopularVideosBinding, PopularVideosViewModel>(R.layout.fragment_popular_videos) {
    override val binding by viewBinding(FragmentPopularVideosBinding::bind)
    override val viewModel: PopularVideosViewModel by viewModels()
    private val adapter = PopularVideosAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribes() {
        viewModel.fetchPopularVideos().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Log.e("videos", it.message.toString())
                    Toast.makeText(requireContext(), it.message.toString(), Toast.LENGTH_LONG).show()
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    adapter.submitList(it.data?.item) }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvPopularVideos.adapter = adapter
    }
}