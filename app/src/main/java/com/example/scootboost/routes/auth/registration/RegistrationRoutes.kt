package com.example.scootboost.routes.auth.registration

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.scootboost.config.NavigationConfig
import com.example.scootboost.routes.Registration
import com.example.scootboost.routes.RegistrationCompany
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.routes.SendCode
import com.example.scootboost.screen.auth.registration.RegistrationScreen
import com.example.scootboost.screen.auth.registration.code.SendCodeScreen
import com.example.scootboost.screen.auth.registration.company.CompanyScreen


fun NavGraphBuilder.registration(navController: NavHostController, currentScreen: RouteBase) {
    composable(
        route = Registration.route,
        enterTransition = {NavigationConfig.fadeIn},
        exitTransition = {NavigationConfig.fadeOut}
    ) {
        RegistrationScreen(navController = navController, currentScreen)
    }
    composable(
        route = SendCode.route
    ){
        SendCodeScreen(navController = navController, currentScreen = currentScreen)
    }
    composable(
        route = RegistrationCompany.route,
        enterTransition = {NavigationConfig.fadeIn},
        exitTransition = {NavigationConfig.fadeOut}
    ) {
        CompanyScreen(navController = navController, currentScreen)
    }
}
