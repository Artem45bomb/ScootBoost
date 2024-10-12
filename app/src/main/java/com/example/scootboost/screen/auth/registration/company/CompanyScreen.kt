package com.example.scootboost.screen.auth.registration.company

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.scootboost.component.FormInput

import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType

@Router(route = "registration/company", groupId = ["auth"])
class CompanyRouter:RouterType

@Composable
fun CompanyScreen(navController: NavController) {
    var email by rememberSaveable {
        mutableStateOf("")
    }

    Column(verticalArrangement = Arrangement.Center) {
        FormInput(value =email , onChangeValue ={email = it})
    }
}