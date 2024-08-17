package com.example.projectmoon.view.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.projectmoon.view.home.retrofit.Items
import com.example.projectmoon.view.home.view.LoadingScreenHome
import com.example.projectmoon.view.home.view.SuccessHomeScreen
import com.example.projectmoon.view.home.viewmodel.HomeVM
import com.example.projectmoon.view.home.viewmodel.StateInteractions


@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen(){
   // SuccessHomeScreen()
}

@Composable
fun HomeScreen(homeVM: HomeVM = viewModel(), navController: NavController){
    val uiState by homeVM.uiState.collectAsState()
    when(uiState){
        is StateInteractions.Loading -> {
            LoadingScreenHome()
        }
        is StateInteractions.Error -> {
            val allListSho = listOf(Items(price = 4542L, id = "24123", type = "dsaw", img_src =  "url"))
            SuccessHomeScreen(allListSho, navController)
          // ErrorScreenHome() //не забыть убрать
        }
        is StateInteractions.Success -> {
            val list = (uiState as StateInteractions.Success).allList
            SuccessHomeScreen(list, navController)
        }
    }

}

