package com.example.projectmoon.view.informationscreen

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectmoon.ProjectApplication
import com.example.projectmoon.R
import com.example.projectmoon.view.basket.room.BasketDao
import com.example.projectmoon.view.home.retrofit.Items
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class InformationVM(private val basketDao: BasketDao) : ViewModel() {


    val isOpen = MutableStateFlow(true)



    suspend fun addItemBasket(itemAdd: Items) {
        viewModelScope.launch {
            // if (itemsShop.value != null) {
            basketDao.addItemBasket(itemAdd)
            basketDao.deleteDuplicate()
            // }

        }
        //  itemsShop.value = null
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY]) as ProjectApplication
                InformationVM(application.getDaoBasketBase())
            }
        }
    }
}