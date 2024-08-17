package com.example.projectmoon.view.basket.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectmoon.view.home.retrofit.Items

@Composable
@Preview(showBackground = true)
fun PreviewInformationDelete() {
   // InformationDeleteScreen({})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformationDeleteScreen(
    onClick: () -> Unit,
    onClickDelete: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onClick() }
    ) {
        Card(
            modifier = Modifier.padding(6.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    fontSize = 21.sp,
                    text = "Удалить?"
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 21.dp)
                ) {
                    OutlinedButton(
                        modifier = Modifier.weight(0.5f),
                        onClick = {
                            onClickDelete()
                            onClick()
                        }
                    ) {
                        Text(
                            fontSize = 18.sp,
                            text = "Да"
                        )
                    }
                    OutlinedButton(
                        modifier = Modifier.weight(0.5f),
                        onClick = { onClick() }
                    ) {
                        Text(
                            fontSize = 18.sp,
                            text = "Нет"
                        )
                    }
                }
            }
        }
    }
}