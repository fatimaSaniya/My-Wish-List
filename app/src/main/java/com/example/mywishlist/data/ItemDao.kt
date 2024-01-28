package com.example.mywishlist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

//step 2: create DAO
@Dao
interface ItemDao {
    @Insert
    suspend fun insert(item: Item) //suspend function - will be called from a co-routine

    @Update
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item: Item)

    @Query("SELECT * FROM items")
    fun getAll(): Flow<List<Item>>

    @Query("SELECT * FROM items where id =:id")
    fun getItem(id: Int): Flow<Item>

}