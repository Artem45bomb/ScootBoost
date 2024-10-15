package com.example.scootboost.ui.header

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.scootboost.data.navigateSingleTopTo
import com.example.scootboost.routes.House
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.routes.routesAll
import com.example.scootboost.ui.header.user.HeaderMain


@Composable
fun TopBar(modifier: Modifier = Modifier,currentScreen:RouteBase,navController: NavHostController,) {
    val navClick:(RouteBase) -> Unit = {navController.navigateSingleTopTo(it.route)}

    when(currentScreen.groupId){
        else -> HeaderMain(modifier, onNavigation = navClick)
    }
}


