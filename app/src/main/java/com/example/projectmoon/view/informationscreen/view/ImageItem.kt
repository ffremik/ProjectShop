package com.example.projectmoon.view.informationscreen.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.projectmoon.R
import com.example.projectmoon.view.home.retrofit.Items
import com.example.projectmoon.view.informationscreen.InformationVM
import kotlinx.coroutines.launch

@Composable
@Preview(showBackground = true)
fun ImagePreviewTitle() {
    // ImageItem()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageItem(
    items: Items
) {
    val pagerState = rememberPagerState { 2 }
    val coroutineState = rememberCoroutineScope()
    val imageList by remember {
        mutableStateOf(
            listOf(
                items.img_src.replace("http", "https"),
                "https://www.interfax.ru/ftproot/photos/photostory/2020/08/07/week1_700.jpg"
            )
        )
    }
    Card(
        modifier = Modifier.padding(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            HorizontalPager(state = pagerState) {
                imageList.forEachIndexed { index, i ->
                    AsyncImage(

                        model = imageList[it],
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(280.dp),
                    )
//
                }

            }

        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            imageList.forEachIndexed { index, i ->
                IconsImageClickable(
                    image = i,
                    index = index,
                    pagerState
                ) {
                    coroutineState.launch {
                        pagerState.animateScrollToPage(index)
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IconsImageClickable(
    image: String,
    index: Int,
    pager: PagerState,
    onClick: () -> Unit
) {

    if (index == pager.currentPage) {
        Box(
            modifier = Modifier
                .padding(4.dp)
                .background(Color.Blue)
        ) {
            AsyncImage(
                contentScale = ContentScale.Crop,
                model = image,
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .padding(3.dp)
                    .clickable { onClick() },

                )

        }
    } else {
        Box(
            modifier = Modifier
                .padding(4.dp)
        ) {
            AsyncImage(
                contentScale = ContentScale.Crop,
                model = image,
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .padding(3.dp)
                    .clickable { onClick() },

                )

        }

    }

}