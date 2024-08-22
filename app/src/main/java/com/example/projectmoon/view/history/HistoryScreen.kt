package com.example.projectmoon.view.history

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun PreviewHistoryScreen() {
    HistoryScreen()
}

@Composable
fun HistoryScreen() {
    Column {
        Text(text = "Экран History")
    }
}