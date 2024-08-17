package com.example.projectmoon.view.basket.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projectmoon.view.home.retrofit.Items

@Database(
    entities = [Items::class],
    version = 1,
    exportSchema = false
)
abstract class BasketDatabase() : RoomDatabase(){
    abstract fun getDaoBasket(): BasketDao

}