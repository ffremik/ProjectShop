package com.example.projectmoon.view.navigation.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.projectmoon.view.navigation.RouteNavigation
import kotlinx.coroutines.launch

@Composable
fun ButtonBar(
    drawerState: DrawerState,
    navController: NavHostController,
    countItems: Int
) {
    val scope = rememberCoroutineScope()
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .height(90.dp)
                   // .safeDrawingPadding()
                        ,
                actions = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        ItemIcon(
                            icon = Icons.Default.Home,
                            content = "Home"
                        ) {
                            navController.navigate(RouteNavigation.HOME_SCREEN.name) {
                                launchSingleTop = true
                                popUpTo(RouteNavigation.HOME_SCREEN.name)
                            }
                        }
                        Box(
                            contentAlignment = Alignment.TopEnd
                        ) {
                            ItemIcon(
                                icon = Icons.Default.ShoppingCart,
                                content = "Shop",
                                onClick = {
                                    navController.navigate(RouteNavigation.BASKET_SCREEN.name) {
                                        launchSingleTop = true
                                    }
                                }

                            )
                            if(countItems > 0){
                                Text(
                                    text = "$countItems",
                                    fontSize = 14.sp
                                )
                            }

                        }
                        ItemIcon(
                            icon = Icons.Default.AccountBox,
                            content = "Account",
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        )
                    }

                }
            )
        }
    ) { padding ->
        NavigationHost(
            modifier = Modifier.padding(padding),
            navController
        )
    }
}