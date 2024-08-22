package com.example.projectmoon.view.basket.workmanager

import android.content.ClipData.Item
import android.content.Context
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewModelScope
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.projectmoon.ProjectApplication
import com.example.projectmoon.view.basket.data.Order
import com.example.projectmoon.view.basket.room.BasketDao
import com.example.projectmoon.view.home.retrofit.Items
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OrderStatusWorker(
    appContext: Context,
    workerParams: WorkerParameters,
) : CoroutineWorker(appContext, workerParams) {

    private val basketDao = (applicationContext as ProjectApplication).getDaoBasketBase()
    override suspend fun doWork(): Result {
        val listItemsJson = inputData.getString("listItems")

        val itemsList = if (listItemsJson != null) {
            Gson().fromJson(listItemsJson, Array<Items>::class.java).toList()
        } else {
            emptyList()
        }
        return try {
            withContext(Dispatchers.IO) {
                itemsList.forEach {
                    if (it.isBuy) {
                        val currentStatus = basketDao.getItem(it.id)
                        while (currentStatus.statusOrder < Order.entries.size - 1) {
                            basketDao.addItemBasket(
                                it.copy(
                                    statusOrder = ++currentStatus.statusOrder,
                                    isOrdered = true,
                                    isBuy = false
                                )
                            )
                            delay(Order.entries[currentStatus.statusOrder].time)
                        }

                    }
                }
            }

            Result.success()
        } catch (throwable: Throwable) {
            Log.e("WorkerManager", "Ошибка")
            Result.failure()
        }

    }

}