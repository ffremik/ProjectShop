package com.example.projectmoon.view.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.projectmoon.R
import com.example.projectmoon.view.home.retrofit.ItemHistoryBuy

@Composable
@Preview(showBackground = true)
fun PreviewItemHistoryBuy() {
   // ItemHistoryBuy()
}

@Composable
fun ItemHistoryBuy(
    itemHistoryBuy: ItemHistoryBuy,
) {
    Card(
        modifier = Modifier
            .padding(6.dp)
    ) {
        Column(
            modifier = Modifier

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
//                Image(
//                    modifier = Modifier.weight(0.4f),
//                    painter = painterResource(id = R.drawable.ic_launcher_background),
//                    contentDescription = ""
//                )
        AsyncImage(
            modifier = Modifier
                .clip(ShapeDefaults.Medium)
                .height(90.dp)
                .weight(0.4f),
            contentScale = ContentScale.Crop,
            model = itemHistoryBuy.img_src.replace("http", "https"),
            contentDescription = ""
        )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(0.6f)
                ) {
                    Text(
                        text = itemHistoryBuy.id,
                        fontSize = 21.sp,
                    )

                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        text = "Дата получения",
                        fontSize = 18.sp
                    )
                    Text(
                        text = itemHistoryBuy.date,
                        fontSize = 18.sp
                    )
                }

            }

        }

    }
}