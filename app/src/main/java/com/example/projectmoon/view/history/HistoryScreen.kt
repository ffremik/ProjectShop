package com.example.projectmoon.view.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.projectmoon.view.history.viewmodel.HistoryVM
import com.example.projectmoon.view.home.retrofit.Items
import com.example.projectmoon.view.home.view.ItemShop

@Composable
@Preview(showBackground = true)
fun PreviewHistoryScreen() {
    //HistoryScreen()
}

@Composable
fun HistoryScreen(
    historyVM: HistoryVM = viewModel(factory = HistoryVM.factory),
) {
    val listHistoryBuy by historyVM.listItemsHistoryBuy.collectAsState(initial = emptyList())
    Column {
        Text(text = "Экран History")

        LazyColumn {
            items(listHistoryBuy) {
                ItemHistoryBuy(
                    itemHistoryBuy = it,
                )
            }
        }
    }
}