package com.example.homework9

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework9.databinding.CategorySelectorsBinding

class CategoryItemAdapter(private val categoryItemList: MutableList<CategoryItem>) :
    RecyclerView.Adapter<CategoryItemAdapter.CategoryItemViewHolder>() {

    var onCategoryItemClickListener: OnCategoryItemClickListener? = null

    interface OnCategoryItemClickListener {
        fun onCategoryItemClick(category: Categories)
    }

    class CategoryItemViewHolder(val binding: CategorySelectorsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val title = binding.categoryBtn
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        return CategoryItemViewHolder(
            CategorySelectorsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun getItemCount(): Int {
        return categoryItemList.size
    }
    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        val currentItem = categoryItemList[position]
        holder.title.text = currentItem.title

        holder.title.setOnClickListener {
            onCategoryItemClickListener?.onCategoryItemClick(Categories.values()[position])
        }

        if (position == 0) {
            holder.title.setBackgroundResource(R.drawable.filter_all_background)
            holder.title.setTextColor(Color.WHITE)
        } else {
            holder.title.setBackgroundResource(R.drawable.filter_button_background)
        }
    }
}