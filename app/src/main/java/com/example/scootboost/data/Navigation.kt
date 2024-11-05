package com.example.scootboost.data

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.scootboost.routes.RouteBase
import okhttp3.Route


fun NavHostController.navigateSingleTopTo(route:String){
    this.navigate(route){
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavHostController.navigateSingleTopTo(route:RouteBase){
    navigateSingleTopTo(route.route)
}

fun NavHostController.navigateToSendCode(userId:Int){
    navigateSingleTopTo("sendCodeScreen/$userId")
}