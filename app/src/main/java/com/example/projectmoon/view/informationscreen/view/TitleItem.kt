package com.example.projectmoon.view.informationscreen.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.projectmoon.view.home.retrofit.Items

@Composable
@Preview(showBackground = true)
fun PreviewTitleItem(){
    //TitleItem()
}


@Composable
fun TitleItem(item: Items) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "Название элемента продажи",
        fontSize = 21.sp,
        textAlign = TextAlign.Center
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(0.25f)
                .padding(start = 6.dp)
        ) {
            TextTitleItem(text = "Артикл:")
            TextTitleItem(text = "Размер:")
            TextTitleItem(text = "Кол-во:")
            TextTitleItem(text = "Цена:")
        }
        Column(
            modifier = Modifier.weight(0.75f)
        ) {
            TextTitleItem(text = item.id)
            TextTitleItem(text = "тут передача")
            TextTitleItem(text = "тут передача")
            TextTitleItem(text = "${item.price}")
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Text(
            fontSize = 21.sp,
            modifier = Modifier,
            text = "Описание"
        )
        TextTitleItem(
            modifier = Modifier
                .padding(top = 6.dp)
            ,
            text = "выфооц йыфв\nывфцу йцу\ndasweqesad qeasd"
        )


    }

}

@Composable
fun TextTitleItem(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = 18.sp,
    )
}