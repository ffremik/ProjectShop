package com.example.projectmoon

import android.app.Application
import androidx.room.Room
import com.example.projectmoon.view.basket.room.BasketDao
import com.example.projectmoon.view.basket.room.BasketDatabase

class ProjectApplication(): Application() {
    private lateinit var basketDatabase: BasketDatabase

    override fun onCreate() {
        super.onCreate()
        basketDatabase = Room
            .databaseBuilder(this, BasketDatabase::class.java, "basketBase")
            .build()
    }
    fun getDaoBasketBase():BasketDao{
        return basketDatabase.getDaoBasket()
    }
}