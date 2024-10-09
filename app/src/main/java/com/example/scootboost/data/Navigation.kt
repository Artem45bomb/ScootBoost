package com.example.scootboost.data

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController


fun NavHostController.navigateSingleTopTo(route:String){
    this.navigate(route){
//        popUpTo(route = this@navigateSingleTopTo.graph.findStartDestination().id){
//            saveState = true
//        }
        launchSingleTop = true
        //restoreState = true
    }
}