package com.example.projectmoon.view.navigation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectmoon.ProjectApplication
import com.example.projectmoon.view.basket.room.BasketDao
import kotlinx.coroutines.flow.MutableStateFlow

class MainVM(private val dao: BasketDao) : ViewModel(){
    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY]) as ProjectApplication
                MainVM(application.getDaoBasketBase())
            }
        }
    }
    val sizeListBasket = dao.getAllItemsBasket()

    val selectedDrawerItem = MutableStateFlow("")

    fun updateSelectedDrawerItem(itemDrawerMenu: String){
        selectedDrawerItem.value = itemDrawerMenu
    }

}