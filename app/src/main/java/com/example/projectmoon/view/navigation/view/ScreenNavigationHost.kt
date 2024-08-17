package com.example.projectmoon.view.navigation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.projectmoon.R
import com.example.projectmoon.view.navigation.viewmodel.MainVM

@Composable
@Preview(showBackground = true)
fun PreviewMainScreen() {
   // ScreenNavigationHost()
}

@Composable
fun ScreenNavigationHost(mainVM: MainVM = viewModel()) {
    val navController = rememberNavController()
    val selectedItem by mainVM.selectedDrawerItem.collectAsState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val listItems = stringArrayResource(id = R.array.items_drawer_menu)

    ModalNavigationDrawer(
        gesturesEnabled = true,
        drawerState = drawerState,
        drawerContent = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {
                ModalDrawerSheet(
                    drawerShape = ShapeDefaults.Small,
                    modifier = Modifier
                        .width(160.dp)
                ) {
                    // DrawerMenu()
                    listItems.forEach {
                        DrawerMenu(
                            item = it,
                            selected = selectedItem,
                        ) {
                            mainVM.updateSelectedDrawerItem(it)
                        }
                    }
                }
            }


        }
    ) {

        ButtonBar(drawerState, navController)
    }

}
