package com.example.scootboost.routes

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.scootboost.routes.auth.authRoutes
import com.example.scootboost.screen.HouseScreen
import com.example.scootboost.ui.menu.Menu


@Composable
fun RoutesController(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    currentScreen: RouteBase,
){


    Box(modifier = modifier){
        NavHost(navController = navController, startDestination = House.route){
            composable(House.route){
                HouseScreen(navController)
            }
            authRoutes(navController,currentScreen)
        }
        Menu(modifier = Modifier,currentScreen = currentScreen)
    }
}