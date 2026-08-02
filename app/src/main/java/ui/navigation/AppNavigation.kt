package com.blackwhitecircle.depo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.blackwhitecircle.depo.ui.screens.CountScreen
import com.blackwhitecircle.depo.ui.screens.HomeScreen
import com.blackwhitecircle.depo.ui.screens.ScannerScreen
import com.blackwhitecircle.depo.ui.screens.SearchScreen
import com.blackwhitecircle.depo.ui.screens.SettingsScreen
import com.blackwhitecircle.depo.ui.screens.ProductScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(navController)
        }

        composable("scanner") {
            ScannerScreen(navController)
        }

        composable("search") {
            SearchScreen()
        }

        composable("count") {
            CountScreen()
        }

        composable("settings") {
            SettingsScreen()
        }
        composable(
            route = "product/{barkod}/{urunKodu}/{urunAdi}/{birim}"
        ) { backStackEntry ->

            ProductScreen(
                barkod = backStackEntry.arguments?.getString("barkod") ?: "",
                urunKodu = backStackEntry.arguments?.getString("urunKodu") ?: "",
                urunAdi = backStackEntry.arguments?.getString("urunAdi") ?: "",
                birim = backStackEntry.arguments?.getString("birim") ?: ""
            )
    }
    }
}