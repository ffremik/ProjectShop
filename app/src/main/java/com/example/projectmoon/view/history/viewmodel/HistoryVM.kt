package com.example.projectmoon.view.history.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.projectmoon.ProjectApplication
import com.example.projectmoon.view.basket.room.BasketDao
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HistoryVM(private val basketDao: BasketDao) : ViewModel() {
    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY]) as ProjectApplication
                HistoryVM(application.getDaoBasketBase())
            }
        }
    }

    val listItemsHistoryBuy = basketDao.getAllItemsHistoryBuy()



}