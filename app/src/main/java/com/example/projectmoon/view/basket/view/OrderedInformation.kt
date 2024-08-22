package com.example.projectmoon.view.basket.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectmoon.view.basket.data.Order
import com.example.projectmoon.view.basket.viewmodel.BasketVM
import com.example.projectmoon.view.home.retrofit.Items
import kotlinx.coroutines.launch

@Composable
@Preview(showBackground = true)
fun PreviewOrderedInformation() {
   // OrderedInformation()
}

@Composable
fun OrderedInformation(
    items: Items,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Text(
            fontSize = 18.sp,
            text = "Статус заказа: ${Order.values()[items.statusOrder].status}"
        )
        if (Order.values()[items.statusOrder] == Order.DELIVERY){
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
                ,
                onClick = { onClick() }
            ) {
                Text(
                    fontSize = 18.sp,
                    text = "Забрать"
                )
            }
        }
    }
}