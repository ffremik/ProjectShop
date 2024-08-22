package com.example.projectmoon.view.navigation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.projectmoon.view.basket.view.BasketScreen
import com.example.projectmoon.view.basket.viewmodel.BasketVM
import com.example.projectmoon.view.contacts.ContactsScreen
import com.example.projectmoon.view.history.HistoryScreen
import com.example.projectmoon.view.home.retrofit.Items
import com.example.projectmoon.view.home.view.HomeScreen
import com.example.projectmoon.view.informationscreen.view.InformationItemScreen
import com.example.projectmoon.view.informationscreen.InformationVM
import com.example.projectmoon.view.navigation.RouteNavigation
import com.example.projectmoon.view.settings.SettingsScreen


@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    basketVM: BasketVM = viewModel(factory = BasketVM.factory)
) {
    val listBasket by basketVM.listItemBasket.collectAsState(initial = emptyList())
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = RouteNavigation.HOME_SCREEN.name
    ) {
        composable(RouteNavigation.HOME_SCREEN.name) {
            HomeScreen(navController = navController)
        }
        composable(RouteNavigation.BASKET_SCREEN.name) {
            BasketScreen(navHostController = navController, basketVM = basketVM)
        }
        composable(RouteNavigation.CONTACTS_SCREEN.route) {
            ContactsScreen()
        }
        composable(RouteNavigation.HISTORY_SCREEN.route) {
            HistoryScreen()
        }
        composable(RouteNavigation.SETTINGS_SCREEN.route) {
            SettingsScreen()
        }
        composable(
            route = RouteNavigation.INFORMATION_SCREEN.name
                    + "?{price}"
                    + "?{id}"
                    + "?{type}"
                    + "?{img_src}",
            arguments = listOf(
                navArgument("price") { type = NavType.LongType },
                navArgument("id") { type = NavType.StringType },
                navArgument("type") { type = NavType.StringType },
                navArgument("img_src") { type = NavType.StringType },
            )
        )
        { arg ->
            val price = arg.arguments?.getLong("price")
            val id = arg.arguments?.getString("id")
            val type = arg.arguments?.getString("type")
            val img_src = arg.arguments?.getString("img_src")

            val item = Items(
                price = price ?: 0L,
                id = id ?: "0",
                type = type ?: "0",
                img_src = img_src ?: "0"
            )
            InformationItemScreen(
                informationVM = viewModel(factory = InformationVM.factory),
                item = item,
                listBasket
            )
            //informationVM
        }
    }
}

