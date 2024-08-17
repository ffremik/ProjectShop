package com.example.projectmoon.view.home.viewmodel

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectmoon.view.home.retrofit.Items
import com.example.projectmoon.view.home.retrofit.ShopApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface StateInteractions {
    data class Success(val allList: List<Items>) : StateInteractions
    object Error: StateInteractions
    object Loading: StateInteractions

}

class HomeVM() : ViewModel() {
    var uiState = MutableStateFlow<StateInteractions>(StateInteractions.Loading)
        private set
    val allListShop = mutableStateOf(emptyList<Items>())

    val progressLoadingTimer = MutableStateFlow(0.1f)

    fun getAllItems() {
        viewModelScope.launch {
            uiState.value = try {
                val result = ShopApi.interactionsRetrofit.getAllItemsShop()
                StateInteractions.Success(result)
            }catch (e: IOException){
                StateInteractions.Error
            }

        }
    }
    init {
        getAllItems()
    }
    

    fun updateTimerLoadingProgress(){
        viewModelScope.launch {
            while (progressLoadingTimer.value <= 1.0f) {
                progressLoadingTimer.value += 0.1f
                delay(500)
                if (progressLoadingTimer.value >= 1.0f){
                    progressLoadingTimer.value = 0.0f
                }
            }
        }
    }
}