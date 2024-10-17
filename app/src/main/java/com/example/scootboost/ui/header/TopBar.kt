package com.example.scootboost.ui.header

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.scootboost.data.navigateSingleTopTo
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.ui.header.user.HeaderMain


@Composable
fun TopBar(modifier: Modifier = Modifier,currentScreen:RouteBase,navController: NavHostController,) {
    val navClick:(RouteBase) -> Unit = {navController.navigateSingleTopTo(it.route)}

    when(currentScreen.groupId){
        else -> HeaderMain(modifier, onNavigation = navClick)
    }
}


