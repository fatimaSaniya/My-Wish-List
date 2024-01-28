package com.example.mywishlist.ui

import com.example.mywishlist.data.Item
import com.example.mywishlist.data.Priority


data class UiState(
    val selectedItem: Item? = null,
    val items: List<Item> = emptyList(),
    val title: String = "",
    val website: String = "",
    val img: String = "",
    val priority: Priority = Priority.Low,
)