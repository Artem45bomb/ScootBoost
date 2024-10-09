package com.example.scootboost.routes.auth.registration

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.scootboost.routes.Registration
import com.example.scootboost.routes.RegistrationCompany
import com.example.scootboost.screen.auth.registration.RegistrationScreen
import com.example.scootboost.screen.auth.registration.company.CompanyScreen


fun NavGraphBuilder.registration(navController: NavController){
    composable(Registration.route){
        RegistrationScreen(navController = navController)
    }
    composable(RegistrationCompany.route){
        CompanyScreen(navController = navController)
    }
}