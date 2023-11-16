package com.example.homework9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework9.databinding.ItemLayoutBinding

class ShopItemAdapter:ListAdapter<Item, ShopItemAdapter.ItemViewHolder>(ItemDiffCallback) {
    companion object{
        val ItemDiffCallback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }
        }
    }
    inner class ItemViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.image
        val price = binding.price
        val title = binding.title
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = getItem(position)
        val imageDrawable = ContextCompat.getDrawable(holder.itemView.context, currentItem.imageResourceId)
        holder.image.setImageDrawable(imageDrawable)
        holder.price.text = currentItem.price
        holder.title.text = currentItem.title
    }
    fun updateItems(filteredItems: List<Item>) {
        submitList(filteredItems)
    }
}