package com.example.scootboost.ui.footer

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.scootboost.component.custom.CNavigationBar
import com.example.scootboost.data.navigateSingleTopTo
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.ui.footer.auth.AuthBottom

@Composable
fun BottomBar(modifier: Modifier = Modifier,currentScreen:RouteBase, navController: NavHostController,) {
    val navClick:(RouteBase) -> Unit = {navController.navigateSingleTopTo(it.route)}

    CNavigationBar{
        with(currentScreen.groupId){
            when {
                this.containsAll(listOf("auth")) -> AuthBottom(modifier, onNavClick = navClick)
                else -> @Composable{}
            }
        }
    }
}


