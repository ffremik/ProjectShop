package com.example.projectmoon.view.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun PreviewSettingScreen() {
    SettingsScreen()
}

@Composable
fun SettingsScreen(){
    Column {
        Text(text = "Экран Settings")
    }
}