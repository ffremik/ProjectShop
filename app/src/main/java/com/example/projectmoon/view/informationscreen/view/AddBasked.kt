package com.example.projectmoon.view.informationscreen.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectmoon.view.home.retrofit.Items

@Composable
@Preview(showBackground = true)
fun PreviewAddItem(){
    //AddItemBasket(213L)
}

@Composable
fun AddItemBasket(item: Items, onClick: (Items) -> Unit) {
    Card(
        modifier = Modifier
            .clickable {
                onClick(item)
            }
            .padding(start = 12.dp, end = 12.dp),

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Стоимость: ${item.price} P",
                fontSize = 16.sp
            )
            Text(
                text = "Добавить в корзину",
                fontSize = 16.sp
            )
        }

    }

}