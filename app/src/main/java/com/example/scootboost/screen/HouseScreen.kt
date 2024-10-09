package com.example.scootboost.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.scootboost.data.navigateSingleTopTo
import com.example.scootboost.routes.Registration
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType

@Router(route = "house")
class HouseRouter: RouterType

@Composable
fun HouseScreen(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Hi")
        Button(onClick = {navController.navigateSingleTopTo(Registration.route)}) {
            Text(text = "sign up")
        }
    }
}