package com.example.scootboost.routes.techSupport

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.routes.TechSupport
import com.example.scootboost.screen.techSupport.TechSupportScreen


fun NavGraphBuilder.techSupport(navController: NavHostController, currentScreen: RouteBase) {
    composable(TechSupport.route) {
        TechSupportScreen(navController = navController)
    }
}