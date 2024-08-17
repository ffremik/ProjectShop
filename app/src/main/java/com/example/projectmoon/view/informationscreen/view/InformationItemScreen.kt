package com.example.projectmoon.view.informationscreen.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectmoon.view.home.retrofit.Items
import com.example.projectmoon.view.informationscreen.InformationVM
import kotlinx.coroutines.launch

@Composable
@Preview(showBackground = true)
fun PreviewInformationScreen() {
    //InformationItemScreen()
}

@Composable //informationVM: InformationVM
fun InformationItemScreen(
    informationVM: InformationVM,
    item: Items,
    listBasket: List<Items>
) {
    val list by remember {
        mutableStateOf(listBasket)
    }
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

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        AddItemBasket(item) {
            coroutine.launch {
                informationVM.addItemBasket(it)
            }
        }

    }

}




