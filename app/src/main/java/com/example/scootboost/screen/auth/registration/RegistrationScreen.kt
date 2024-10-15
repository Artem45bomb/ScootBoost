package com.example.scootboost.screen.auth.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.scootboost.R
import com.example.scootboost.component.FormInput
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.ui.auth.PolicyChecked
import com.example.scootboost.ui.auth.nav.BtnNav
import com.example.scootboost.ui.btn.BtnBlack
import com.example.scootboost.ui.btn.BtnIcon
import com.example.scootboost.ui.logo.LogoAuth

@Router(route = "registration",groupId = ["auth"])
class RegistrationRouter: RouterType

@Composable
fun RegistrationScreen(navController: NavHostController,currentScreen:RouteBase) {
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var phone by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var passwordCopy by rememberSaveable {
        mutableStateOf("")
    }
    var checkPolicy by rememberSaveable {
        mutableStateOf(true)
    }

    //ScrollableColumn
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 30.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Регистрация",
                style=MaterialTheme.typography.titleLarge.copy(MaterialTheme.colorScheme.secondary),
                textAlign = TextAlign.Center
            )
            BtnNav(navController= navController, currentRoute = currentScreen.route)
        }
        LogoAuth(Modifier.width(90.dp))
        Column(verticalArrangement =Arrangement.spacedBy(10.dp)){
            FormInput(value = email, onChangeValue = {email = it}, placeholder = "Имя")
            FormInput(value = phone, onChangeValue = {phone = it}, type = "phone", placeholder = "Телефон", textInfo = "Код будет направлен в SMS")
            FormInput(value = password, onChangeValue = {password = it}, type = "password", placeholder = "Придумайте пароль")
            FormInput(value = passwordCopy, onChangeValue = {passwordCopy = it}, type = "phone", placeholder = "Подтвердите пароль")
            PolicyChecked(value =checkPolicy, onChange ={checkPolicy=it})
        }
        BtnBlack(text = "Продолжить") {
            
        }
        BtnIcon(id = R.drawable.google_logo, description = "google icon", colorButton =MaterialTheme.colorScheme.primary) {

        }
    }
}