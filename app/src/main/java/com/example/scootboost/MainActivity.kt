package com.example.scootboost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.scootboost.routes.House
import com.example.scootboost.routes.RoutesController
import com.example.scootboost.routes.routesAll
import com.example.scootboost.ui.menu.Menu
import com.example.scootboost.ui.theme.ScootBoostTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            ScootBoostTheme {
                ProvideTextStyle(value = MaterialTheme.typography.bodyMedium) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        RoutesController(navController = navController,Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var visible by remember {
        mutableStateOf(false)
    }


    Column {
        Button(onClick = { visible = !visible }) {
            Text("click")
        }
        Menu(modifier = Modifier.width(171.dp),visible)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScootBoostTheme {
        Greeting("Android")
    }
}