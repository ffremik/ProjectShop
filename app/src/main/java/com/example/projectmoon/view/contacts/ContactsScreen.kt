package com.example.projectmoon.view.contacts

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview



@Composable
@Preview(showBackground = true)
fun ContactsPreviewScreen(){
    ContactsScreen()
}

@Composable
fun ContactsScreen() {
    Column {
       Text(text = "Экран Контакты")
    }
}
