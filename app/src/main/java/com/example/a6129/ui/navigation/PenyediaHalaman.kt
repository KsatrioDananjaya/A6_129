package com.example.a6129.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.a6129.ui.view.HomeApp

@Composable
fun PengelolaHalaman(
    modifier : Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = DestinasiMain.route,
        modifier = Modifier,
    ) {
        composable(route = DestinasiMain.route) {
            HomeApp(
                onAcara = {
                    navController.navigate(DestinasiAcara.route)
                },
                onKlien = {
                    navController.navigate(DestinasiKlien.route)
                },
                onLokasi = {
                    navController.navigate(DestinasiLokasi.route)
                },
                onVendor = {
                    navController.navigate(DestinasiVendor.route)
                }
            )
        }
    }
}