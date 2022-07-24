package com.dontsu.digimonadventure.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dontsu.digimonadventure.databinding.ItemMainDigimonBinding
import com.dontsu.digimonadventure.extensions.load
import com.dontsu.domain.model.Content
import timber.log.Timber

class DigimonListAdapter(
    private val itemClicked: (Content) -> Unit
): ListAdapter<Content, DigimonListAdapter.DigmonContentViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DigmonContentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainDigimonBinding.inflate(inflater, parent, false)
        return DigmonContentViewHolder(binding = binding).apply {
            itemView.setOnClickListener {
                val position = bindingAdapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return@setOnClickListener
                itemClicked(getItem(position))
            }
        }
    }

    override fun onBindViewHolder(holder: DigmonContentViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DigmonContentViewHolder(
        private val binding: ItemMainDigimonBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(content: Content) = with(binding) {
            digimonImageView.load(content.name)
            digimonNamteTextView.text = content.name ?: "not found"
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
