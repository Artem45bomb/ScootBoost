package com.example.scootboost.routes.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.scootboost.routes.Login
import com.example.scootboost.routes.Registration
import com.example.scootboost.screen.auth.LoginScreen
import com.example.scootboost.screen.auth.RegistrationScreen


fun NavGraphBuilder.authRoutes(navController:NavHostController) {
        composable(Registration.route) {
            RegistrationScreen(navController)
        }
        composable(Login.route) {
            LoginScreen(navController)
        }
} 