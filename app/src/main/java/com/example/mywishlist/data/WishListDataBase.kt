package com.example.mywishlist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


// step 3: Create database
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class WishListDataBase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
    companion object {
        @Volatile
        private var Instance: WishListDataBase? = null
        fun getDatabase(context: Context): WishListDataBase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, WishListDataBase::class.java, "wishlist_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}