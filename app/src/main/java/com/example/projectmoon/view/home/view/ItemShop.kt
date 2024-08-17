package com.example.projectmoon.view.home.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.projectmoon.view.home.retrofit.Items
import com.example.projectmoon.view.navigation.RouteNavigation

@Composable
@Preview(showBackground = true)
fun PreviewItemShop() {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        //ItemShop(Items(3213, "2123", "dwqea","img")){}
    }
}

@Composable
fun ItemShop(itemShop: Items, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .clickable {
                navController.navigate(
                    RouteNavigation.INFORMATION_SCREEN.name
                            + "?${itemShop.price}"
                            + "?${itemShop.id}"
                            + "?${itemShop.type}"
                            + "?${itemShop.img_src}"
                ) {
                    launchSingleTop = true
                }
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 150.dp)
                    .padding(12.dp)
                    .clip(ShapeDefaults.Medium),
                contentScale = ContentScale.Crop,
                model = "${itemShop.img_src.replace("http", "https")}",
                contentDescription = ""
            )

//            Image(
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .heightIn(max = 300.dp)
//                    .padding(12.dp)
//                    .clip(ShapeDefaults.Medium),
//                imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_background),
//                contentDescription = ""
//            )

            Text(
                text = "Цена: ${itemShop.price} Р",
                fontSize = 18.sp
            )
            Text(
                textAlign = TextAlign.Start,
                maxLines = 2,
                text = "Артикл: ${itemShop.id}",
                fontSize = 18.sp
            )
        }
    }
}