package com.example.projectmoon.view.basket.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectmoon.ProjectApplication
import com.example.projectmoon.view.basket.room.BasketDao
import com.example.projectmoon.view.home.retrofit.Items
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BasketVM(private val basketDao: BasketDao) : ViewModel(){
    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY]) as ProjectApplication
                BasketVM(application.getDaoBasketBase())
            }
        }
    }

    val listItemBasket = basketDao.getAllItemsBasket()
    val isOpenDeleteItem = MutableStateFlow(false)

    fun updateIsOpenDeleteItem(){
        isOpenDeleteItem.value = !isOpenDeleteItem.value
    }

    fun deleteItem(item: Items) {
        viewModelScope.launch {
            basketDao.deleteItemBasket(item)
        }
    }

}