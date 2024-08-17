package com.example.projectmoon.view.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projectmoon.view.home.retrofit.Items

@Composable
fun SuccessHomeScreen(allListShop: List<Items>, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        //SearchItem()
        LazyVerticalGrid(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            columns = GridCells.Fixed(2)
        ) {
            items(allListShop) {
                ItemShop(
                    itemShop = it,
                    navController
                )
            }
        }
    }
}

@Composable
fun SearchItem() {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {

            },
            label = {
                Text(text = "Поиск")
            }
        )
    }
}