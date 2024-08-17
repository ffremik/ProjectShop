package com.example.projectmoon.view.navigation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainVM() : ViewModel(){
    //val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val selectedDrawerItem = MutableStateFlow("")

    fun updateSelectedDrawerItem(itemDrawerMenu: String){
        selectedDrawerItem.value = itemDrawerMenu
    }

}