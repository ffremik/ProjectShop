package com.example.projectmoon.view.basket.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
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
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    if (!itemShop.isOrdered) {
                        Checkbox(
                            modifier = Modifier
                                .padding(start = 12.dp, top = 12.dp),
                            checked = itemShop.isBuy,
                            onCheckedChange = {
                                basketVM.updateIsBue(itemShop)
                            }
                        )
                        IconButton(
                            modifier = Modifier
                                .padding(end = 12.dp, top = 12.dp),
                            onClick = { onClick(itemShop) }
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(30.dp),
                                imageVector = Icons.Default.Delete,
                                contentDescription = ""
                            )
                        }
                    }

                }

            }
            if (itemShop.isOrdered) {
                OrderedInformation(itemShop) {
                    basketVM.addItemHistoryBuy(itemShop)
                }

            } else {
                Text(
                    text = "Цена: ${itemShop.price} Р ${itemShop.statusOrder} ${itemShop.isOrdered}",
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
    }
    if (isOpenDelete) {
        InformationDeleteScreen(
            onClick = { basketVM.updateIsOpenDeleteItem() }
        ) {
            basketVM.deleteItem(itemShop)
        }
    }
}