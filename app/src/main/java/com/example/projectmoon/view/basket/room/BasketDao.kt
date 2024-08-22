package com.example.projectmoon.view.basket.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.projectmoon.view.home.retrofit.Items
import kotlinx.coroutines.flow.Flow

@Dao
interface BasketDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItemBasket(item: Items)

    @Query("SELECT * FROM itemBasket")
    fun getAllItemsBasket(): Flow<List<Items>>

    @Query("SELECT * FROM itemBasket WHERE id LIKE :id ")
    suspend fun getItem(id: String): Items

    @Query("DELETE FROM itemBasket\n" +
            "WHERE id IN (\n" +
            "SELECT id FROM itemBasket GROUP BY id HAVING COUNT() > 1 \n" +
            ") AND ROWID NOT IN (\n" +
            "SELECT MIN (ROWID)\n" +
            "FROM itemBasket\n" +
            "GROUP BY id\n" +
            "HAVING COUNT () > 1\n" +
            ") ")
    suspend fun deleteDuplicate()

    @Delete
    suspend fun deleteItemBasket(item: Items)
}