package com.example.mywishlist.data

import android.content.Context


//step 6: create app container
interface AppContainer {
    val itemsRepository: WishListRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val itemsRepository: WishListRepository by lazy {
        LocalWishListRepository(WishListDataBase.getDatabase(context).itemDao())
    }
}