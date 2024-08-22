package com.example.projectmoon.view.navigation.view

import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.projectmoon.view.navigation.RouteNavigation

@Composable
@Preview(showBackground = true)
fun PreviewDrawerMenu() {
   // DrawerMenu()
}

@Composable
fun DrawerMenu(
    item: String,
    selected : String,
    navHostController: NavHostController
) {
    NavigationDrawerItem(

        label = {
            Text(text = item)
        },
        selected = item == selected,
        onClick = {
            navHostController.navigate(item) {
                launchSingleTop = true
            }
        }
    )
}