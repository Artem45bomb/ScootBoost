package com.example.scootboost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.scootboost.routes.House
import com.example.scootboost.routes.RoutesController
import com.example.scootboost.routes.routesAll
import com.example.scootboost.ui.footer.BottomBar
import com.example.scootboost.ui.header.TopBar
import com.example.scootboost.ui.theme.ScootBoostTheme
import com.google.android.material.navigation.NavigationBarView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val currentBackStack by navController.currentBackStackEntryAsState()
            val currentDestination = currentBackStack?.destination
            val currentScreen = routesAll.find{ it.route == currentDestination?.route } ?: House


            ScootBoostTheme {
                ProvideTextStyle(
                    value = MaterialTheme.typography.bodyMedium) {
                    Scaffold(
                        bottomBar = {
                                BottomBar(navController=navController,currentScreen=currentScreen)
                        },
                        topBar ={TopBar(navController = navController, currentScreen = currentScreen)},
                        modifier = Modifier.fillMaxSize()
                    ) { innerPadding ->
                        RoutesController(navController = navController,currentScreen = currentScreen,Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}
