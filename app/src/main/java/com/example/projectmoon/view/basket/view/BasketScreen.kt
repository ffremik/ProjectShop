package com.example.projectmoon.view.basket.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.projectmoon.view.basket.viewmodel.BasketVM
import com.example.projectmoon.view.home.retrofit.Items

@Composable
@Preview(showBackground = true)
fun PreviewBasketScreen() {
    // BasketScreen()
}

@Composable
fun BasketScreen(
    basketVM: BasketVM,
    navHostController: NavHostController
) {
    val listBasket by basketVM.listItemBasket.collectAsState(initial = emptyList())
    val sum by basketVM.sumBasket.collectAsState()
    val count by basketVM.countBasket.collectAsState()
    basketVM.sumItemBasket(listBasket)

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            TotalSumCard(sum, count) {
              //  basketVM.orderedItems(listBasket)
                basketVM.updateOrderStatus(listBasket)
            }
        }
        LazyColumn {
            items(listBasket) {
                if (!it.isHistoryBuy) {
                    ItemSBasket(
                        itemShop = it,
                        navController = navHostController,
                        basketVM = basketVM
                    ) {
                        basketVM.updateIsOpenDeleteItem()
                    }
                }
            }
        }
    }

}

@Composable
fun TotalSumCard(
    sum: Long,
    count: Int,
    onClick: () -> Unit
) {
    // val sum = list.sumOf { it.price }
    Card(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1.0f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(

                    text = "Сумма: $sum ",
                    fontSize = 18.sp
                )
                Text(
                    fontSize = 18.sp,
                    text = "Кол-во: $count "
                )
            }
            IconButton(
                onClick = {
                    onClick()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = ""
                )
            }
        }

    }
}
