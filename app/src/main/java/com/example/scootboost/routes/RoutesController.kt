package com.example.scootboost.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.scootboost.routes.auth.authRoutes
import com.example.scootboost.screen.HouseScreen


@Composable
fun RoutesController(navController: NavHostController,modifier: Modifier = Modifier){
    NavHost(navController = navController, startDestination = House.route, modifier = modifier){
        composable(House.route){
            HouseScreen(navController)
        }
        authRoutes(navController)
    }
}

