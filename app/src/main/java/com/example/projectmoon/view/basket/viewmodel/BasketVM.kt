package com.example.projectmoon.view.basket.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.projectmoon.ProjectApplication
import com.example.projectmoon.view.basket.data.Order
import com.example.projectmoon.view.basket.room.BasketDao
import com.example.projectmoon.view.basket.workmanager.OrderStatusWorker
import com.example.projectmoon.view.home.retrofit.Items
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class BasketVM(
    private val basketDao: BasketDao,
    private val workerManager: WorkManager
) : ViewModel() {
    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY]) as ProjectApplication
                BasketVM(
                    application.getDaoBasketBase(),
                    WorkManager.getInstance(application)
                )
            }
        }
    }

    val sumBasket = MutableStateFlow(0L)
    val countBasket = MutableStateFlow(0)

    val listItemBasket = basketDao.getAllItemsBasket()

    val isOpenDeleteItem = MutableStateFlow(false)
    val sizeStatusOrder = MutableStateFlow(Order.values())
    val currentStatusOrder = MutableStateFlow(sizeStatusOrder.value[0])

    fun updateIsOpenDeleteItem() {
        isOpenDeleteItem.value = !isOpenDeleteItem.value
    }

    fun deleteItem(item: Items) {
        viewModelScope.launch {
            basketDao.deleteItemBasket(item)
        }
    }

    fun updateIsBue(item: Items) {
        viewModelScope.launch {
            basketDao.addItemBasket(item.copy(isBuy = !item.isBuy))
        }

    }

    fun addItemHistoryBuy(item: Items){
        viewModelScope.launch {
            basketDao.addItemBasket(item.copy(isHistoryBuy = true))
        }
    }

    fun sumItemBasket(list: List<Items>) {
        sumBasket.value = list.sumOf { if (it.isBuy) it.price else 0 }
        countBasket.value = list.count { it.isBuy }
    }

    fun updateOrderStatus(list: List<Items>) {
        workerManager.enqueueUniqueWork(
            "updateStatus",
            ExistingWorkPolicy.REPLACE,
            OneTimeWorkRequest.Builder(
                OrderStatusWorker::class.java,
            )
                .setInputData(workDataOf("listItems" to Gson().toJson(list)))
                .build()
        )
    }


}