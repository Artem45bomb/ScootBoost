package com.example.scootboost.ui.footer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.scootboost.data.navigateSingleTopTo
import com.example.scootboost.routes.House
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.routes.routesAll
import com.example.scootboost.ui.footer.auth.AuthBottom
import com.example.scootboost.ui.header.user.HeaderMain

@Composable
fun BottomBar(modifier: Modifier = Modifier,currentScreen:RouteBase, navController: NavHostController,) {
    val navClick:(RouteBase) -> Unit = {navController.navigateSingleTopTo(it.route)}

    when(currentScreen.groupId){
        listOf("auth") -> AuthBottom(modifier,onNavClick = navClick)
        else -> @Composable{}
    }
}


