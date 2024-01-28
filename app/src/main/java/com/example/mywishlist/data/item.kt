package com.example.mywishlist.data

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class Priority{
    High,
    Medium,
    Low
}


//step 1: create data class as entity
@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int= 0,
    val title: String,
    val website: String,
    val img : String ="",
    val imgLocal: Int = 0,
    val priority: Priority = Priority.Low, // enum in Room is stored in int
    val isImgLocal: Boolean = false, // Boolean in Room is stored in int
    val createdAt: Long = System.currentTimeMillis() //timeStamp
)