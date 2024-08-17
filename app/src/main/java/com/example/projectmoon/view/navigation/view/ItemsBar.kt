package com.example.projectmoon.view.navigation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true)
fun PreviewItems() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ItemIcon(
            icon = Icons.Default.AccountBox,
            content = "Account",
            onClick = {}
        )
    }
}

@Composable
fun ItemIcon(
    icon: ImageVector,
    content: String,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(25.dp),
            imageVector = icon,
            contentDescription = content
        )
    }
}