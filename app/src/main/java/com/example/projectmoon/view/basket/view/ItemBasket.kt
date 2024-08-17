package com.example.projectmoon.view.basket.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.projectmoon.R
import com.example.projectmoon.view.basket.viewmodel.BasketVM
import com.example.projectmoon.view.home.retrofit.Items
import com.example.projectmoon.view.navigation.RouteNavigation

@Composable
fun ItemSBasket(
    itemShop: Items,
    navController: NavController,
    basketVM: BasketVM,
    onClick: (Items) -> Unit
) {
    val isOpenDelete by basketVM.isOpenDeleteItem.collectAsState()
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

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.TopEnd
            ) {
                AsyncImage(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 300.dp)
                        .padding(12.dp)
                        .clip(ShapeDefaults.Medium),
                    model = itemShop.img_src.replace("http", "https"),
                    contentDescription = ""
                )
                Icon(
                    modifier = Modifier
                        .clickable {
                            onClick(itemShop)
                        }
                        .size(45.dp)
                        .padding(end = 12.dp, top = 12.dp),
                    imageVector = Icons.Default.Delete,
                    contentDescription = ""
                )
            }

            Text(
                text = "Цена: ${itemShop.price} Р",
                fontSize = 18.sp
            )
            Text(
                textAlign = TextAlign.Start,
                maxLines = 2,
                text = "Название ${itemShop.id}",
                fontSize = 18.sp
            )
        }
    }
    if (isOpenDelete){
        InformationDeleteScreen(
            onClick = {basketVM.updateIsOpenDeleteItem()}
        ) {
            basketVM.deleteItem(itemShop)
        }
    }
}