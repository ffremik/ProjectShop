package com.example.projectmoon.view.navigation.view

import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun PreviewDrawerMenu() {
   // DrawerMenu()
}

@Composable
fun DrawerMenu(
    item: String,
    selected : String,
    onClick: (String)->Unit
) {
    NavigationDrawerItem(

        label = {
            Text(text = item)
        },
        selected = item == selected,
        onClick = { onClick(item) }
    )
}