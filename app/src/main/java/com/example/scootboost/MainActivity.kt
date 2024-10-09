package com.example.scootboost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.scootboost.component.FormInput
import com.example.scootboost.ui.theme.ScootBoostTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ScootBoostTheme {
                ProvideTextStyle(value = MaterialTheme.typography.bodyMedium) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    val inputString = "Check if this string contains only English characters"
    val englishRegex = Regex("^[a-zA-Z]+$")
    FormInput(value = text ,placeholder = "Name", onChangeValue = {text=it}, errorCheck = englishRegex , errorValue = inputString)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScootBoostTheme {
        Greeting("Android")
    }
}