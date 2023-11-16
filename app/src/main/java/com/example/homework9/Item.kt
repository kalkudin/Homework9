package com.example.homework9

data class Item(
    val id: Int,
    val title:String,
    val price:String,
    val imageResourceId:Int,
    val category: Categories
    ){
}

enum class Categories{
    ALL,
    PARTY,
    CAMPING,
    CATEGORY1,
    CATEGORY2,
    CATEGORY3,
}