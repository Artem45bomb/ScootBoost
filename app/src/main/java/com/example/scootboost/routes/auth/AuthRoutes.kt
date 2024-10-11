package com.example.scootboost.routes.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.scootboost.routes.Login
import com.example.scootboost.routes.auth.registration.registration
import com.example.scootboost.screen.auth.LoginScreen


fun NavGraphBuilder.authRoutes(navController:NavHostController) {
        composable(Login.route) {
            LoginScreen(navController)
        }
        registration(navController)
} 