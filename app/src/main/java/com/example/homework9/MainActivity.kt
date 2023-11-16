package com.example.homework9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CategoryItemAdapter.OnCategoryItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterShopItem: ShopItemAdapter
    private lateinit var adapterCategoryItem: CategoryItemAdapter
    private val items = mutableListOf<Item>()
    private val categoryItems = mutableListOf<CategoryItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        populateItemList()
        populateCategoryList()
        setUpItemListAdapter()
        setUpCategoryListAdapter()
    }

    private fun populateCategoryList() {
        categoryItems.also {
            it.add(CategoryItem(title = "All"))
            it.add(CategoryItem(title = "\uD83C\uDF89  Party"))
            it.add(CategoryItem(title = "\uD83C\uDFD5  Camping"))
            it.add(CategoryItem(title = "Category1"))
            it.add(CategoryItem(title = "Category2"))
            it.add(CategoryItem(title = "Category3"))
        }
    }

    private fun populateItemList() {
        items.also {
            it.add(Item(id = 1, title = "Belt suit blazer", price = "$120", imageResourceId = R.drawable.model1, category = Categories.PARTY))
            it.add(Item(id = 2, title = "esec asworebs", price = "$100", imageResourceId = R.drawable.model1, category = Categories.CAMPING))
            it.add(Item(id = 3, title = "kargi ramea", price = "$90", imageResourceId = R.drawable.model4, category = Categories.CAMPING))
            it.add(Item(id = 4, title = "Belt suit blazer", price = "$80", imageResourceId = R.drawable.model3, category = Categories.PARTY))
            it.add(Item(id = 5, title = "its fine i guess", price = "$70", imageResourceId = R.drawable.model3, category = Categories.PARTY))
            it.add(Item(id = 6, title = "magari tansacmelia", price = "$60", imageResourceId = R.drawable.model2, category = Categories.CATEGORY2))
            it.add(Item(id = 7, title = "Belt suit blazer", price = "$50", imageResourceId = R.drawable.model1, category = Categories.CATEGORY3))
            it.add(Item(id = 8, title = "kide uketesi tansacmelia", price = "$50", imageResourceId = R.drawable.model3, category = Categories.CATEGORY1))
            it.add(Item(id = 9, title = "sauketeso rame esaa", price = "$50", imageResourceId = R.drawable.model2, category = Categories.CATEGORY1))
            it.add(Item(id = 9, title = "sauketeso rame esaa", price = "$50", imageResourceId = R.drawable.model1, category = Categories.CATEGORY3))
            it.add(Item(id = 9, title = "sauketeso rame esaa", price = "$50", imageResourceId = R.drawable.model4, category = Categories.CATEGORY2))
        }
    }

    private fun setUpItemListAdapter() {
        adapterShopItem = ShopItemAdapter()
        binding.itemBar.layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)
        binding.itemBar.adapter = adapterShopItem
        adapterShopItem.submitList(items)
    }

    private fun setUpCategoryListAdapter() {
        adapterCategoryItem = CategoryItemAdapter(categoryItems)
        adapterCategoryItem.onCategoryItemClickListener = this
        binding.itemFilterBar.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterCategoryItem
        }
    }
    override fun onCategoryItemClick(category: Categories) {
        val filteredItems = when (category) {
            Categories.ALL -> items
            else -> items.filter { it.category == category }
        }
        adapterShopItem.updateItems(filteredItems)
    }
}