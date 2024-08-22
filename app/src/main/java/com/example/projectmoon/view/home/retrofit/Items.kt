package com.example.projectmoon.view.home.retrofit

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "itemBasket")
data class Items(
    @PrimaryKey(autoGenerate = true)
    val autoId: Int = 0,
    val price: Long,
    val id: String,
    val img_src: String,
    val type: String,
    val isBuy: Boolean = true,
    val isOrdered: Boolean = false,
    var statusOrder: Int = -1,
    val isHistoryBuy: Boolean = false

)
