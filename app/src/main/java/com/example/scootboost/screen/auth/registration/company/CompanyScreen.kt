package com.example.scootboost.screen.auth.registration.company

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.scootboost.R
import com.example.scootboost.component.FormInput
import com.example.scootboost.config.inputRegex
import com.example.scootboost.data.model.UserRegistrationData
import com.example.scootboost.data.navigateSingleTopTo
import com.example.scootboost.routes.RouteBase

import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.routes.SendCode
import com.example.scootboost.ui.auth.PolicyChecked
import com.example.scootboost.ui.auth.nav.BtnNav
import com.example.scootboost.ui.btn.BtnBlack
import com.example.scootboost.ui.btn.BtnIcon
import com.example.scootboost.ui.logo.LogoAuth

@Router(route = "registration/company", groupId = ["auth"])
class CompanyRouter:RouterType

@Composable
fun CompanyScreen(navController: NavHostController,currentScreen:RouteBase) {
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
    var urlCompany by rememberSaveable {
        mutableStateOf("")
    }
    var nameCompany by rememberSaveable {
        mutableStateOf("")
    }


    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 20.dp, horizontal = 30.dp)
    ) {
        IconButton(onClick = { navController.popBackStack() }, Modifier.align(Alignment.Start)) {
            Icon(
                painterResource(id = R.drawable.back),
                "back icon",
                tint = MaterialTheme.colorScheme.secondary
            )
        }
        Text(
            "Регистрация",
            style = MaterialTheme.typography.titleLarge.copy(MaterialTheme.colorScheme.secondary),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        BtnNav(navController = navController, currentRoute = currentScreen.route)
        LogoAuth(Modifier.width(90.dp))
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            FormInput(value = nameCompany, onChangeValue = { nameCompany = it }, placeholder = "Наименование компании")
            FormInput(value = urlCompany, onChangeValue = { urlCompany = it }, placeholder = "URL адрес компании")
            FormInput(value = email, onChangeValue = { email = it }, placeholder = "Email")
            FormInput(
                value = phone,
                onChangeValue = { phone = it },
                type = "phone",
                placeholder = "Телефон"
            )
            FormInput(
                value = password,
                onChangeValue = { password = it },
                type = "password",
                errorCheck = Regex(inputRegex.password),
                errorValue = "Пароль должен начинаться от 8 символов и содержать a-Z",
                placeholder = "Придумайте пароль"
            )
            FormInput(
                value = passwordCopy,
                onChangeValue = { passwordCopy = it },
                type = "password",
                errorCheck = Regex("^$password$"),
                errorValue = "The password must match",
                placeholder = "Подтвердите пароль"
            )
            PolicyChecked(value = checkPolicy, onChange = { checkPolicy = it })
        }
        BtnBlack(text = "Продолжить", enabled = checkPolicy) {
        }
    }
}