package com.dontsu.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dontsu.presentation.databinding.ItemListLoadingStateBinding
import com.dontsu.presentation.extensions.setOnSingleClickListener
import com.dontsu.presentation.extensions.toVisible

class DigimonLoadingStateAdapter(private val retry: () -> Unit) : LoadStateAdapter<DigimonLoadingStateAdapter.DigimonLoadingStateViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): DigimonLoadingStateViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListLoadingStateBinding.inflate(inflater, parent, false)
        return DigimonLoadingStateViewHolder(binding, retry)
    }

    override fun onBindViewHolder(holder: DigimonLoadingStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    class DigimonLoadingStateViewHolder(
        private val binding: ItemListLoadingStateBinding,
        retry: () -> Unit
    ): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.btnLoadingRetry.setOnSingleClickListener {
                retry()
            }
        }

        fun bind(loadState: LoadState) = with(binding) {
            pbLoadingRetry.toVisible(loadState is LoadState.Loading)
            btnLoadingRetry.toVisible(loadState !is LoadState.Loading)
            tvLoadingRetryNotice.toVisible(loadState !is LoadState.Loading)
        }

    }

}
