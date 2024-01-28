package com.example.mywishlist

import android.app.Application
import com.example.mywishlist.data.AppDataContainer

//step 9: create application class and
class WishListApplication : Application() {
    lateinit var container: AppDataContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
