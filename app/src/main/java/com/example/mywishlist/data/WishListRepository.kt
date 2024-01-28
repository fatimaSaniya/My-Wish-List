package com.example.mywishlist.data

import kotlinx.coroutines.flow.Flow

//step 4: create repository interface
interface WishListRepository {
    fun getWishList(): Flow<List<Item>>
    fun getWishListItem(id: Int): Flow<Item>
    suspend fun addItem(item : Item)
    suspend fun removeItem(item : Item)
    suspend fun updateItem(item : Item)
}