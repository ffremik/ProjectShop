package com.example.projectmoon.view.home.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projectmoon.view.home.viewmodel.HomeVM
import com.example.projectmoon.view.home.viewmodel.StateInteractions

@Composable
@Preview(showBackground = true)
fun PreviewLoadingScreenHome() {
    LoadingScreenHome()
}


@Composable
fun LoadingScreenHome(homeVM: HomeVM = viewModel()) {
    val uiState by homeVM.uiState.collectAsState()
    val timerLoading by homeVM.progressLoadingTimer.collectAsState()
    Column(

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (uiState == StateInteractions.Loading){
            CircularProgressIndicator(
                progress = timerLoading,
                color = Color.Red
            )
            Text(
                text = "Получение данных",
                fontSize = 18.sp,
                color = Color.Blue
            )
            LaunchedEffect(key1 = uiState) {
                homeVM.updateTimerLoadingProgress()
            }

        }
    }
}