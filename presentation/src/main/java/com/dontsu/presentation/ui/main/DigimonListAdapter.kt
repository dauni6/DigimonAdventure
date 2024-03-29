package com.dontsu.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dontsu.presentation.extension.loadWithName
import com.dontsu.domain.model.Content
import com.dontsu.presentation.databinding.ItemMainDigimonBinding

class DigimonListAdapter(
    private val itemClicked: (Content) -> Unit
): ListAdapter<Content, DigimonListAdapter.DigimonContentViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigimonContentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainDigimonBinding.inflate(inflater, parent, false)
        return DigimonContentViewHolder(binding = binding).apply {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return@setOnClickListener
                itemClicked(getItem(position))
            }
        }
    }

    override fun onBindViewHolder(holder: DigimonContentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DigimonContentViewHolder(
        private val binding: ItemMainDigimonBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(content: Content) = with(binding) {
            digimonImageView.loadWithName(content.name)
            digimonNameTextView.text = content.name ?: "not found"
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Content>() {

            // compare unique value
            override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean {
               return oldItem.id == newItem.id
            }

            // compare item itself.
            override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean {
               return oldItem == newItem
            }

        }
    }

}
