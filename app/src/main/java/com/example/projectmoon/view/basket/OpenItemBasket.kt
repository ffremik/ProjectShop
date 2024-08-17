package com.example.projectmoon.view.basket

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.projectmoon.view.home.retrofit.Items
import com.example.projectmoon.view.informationscreen.InformationVM
import com.example.projectmoon.view.informationscreen.view.ImageItem
import com.example.projectmoon.view.informationscreen.view.TitleItem

@Composable
fun ScreenOpenItem(
    informationVM: InformationVM,
    item: Items
) {
    val coroutine = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        ImageItem(item)
        TitleItem(item)
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
        )
    }
}