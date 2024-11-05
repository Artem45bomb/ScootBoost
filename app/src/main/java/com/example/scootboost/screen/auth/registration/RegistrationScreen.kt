package com.example.scootboost.screen.auth.registration

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.scootboost.api.auth.request.registration
import com.example.scootboost.api.isNotEmpty
import com.example.scootboost.component.input.FormInput
import com.example.scootboost.config.InputRegex
import com.example.scootboost.data.model.SignUpDTO
import com.example.scootboost.data.model.UserRegistrationData
import com.example.scootboost.data.model.UserSettings
import com.example.scootboost.data.navigateSingleTopTo
import com.example.scootboost.data.view.RegistrationView
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.routes.SendCode
import com.example.scootboost.ui.auth.PolicyChecked
import com.example.scootboost.ui.auth.nav.BtnNav
import com.example.scootboost.ui.btn.BtnBlack
import com.example.scootboost.ui.btn.nav.Back
import com.example.scootboost.ui.logo.LogoAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Router(route = "registration", groupId = ["auth"])
class RegistrationRouter : RouterType


@Composable
fun RegistrationScreen(
    navController: NavHostController,
    currentScreen: RouteBase,
    registrationView: RegistrationView = viewModel()
) {
    var error by rememberSaveable {
        mutableStateOf("")
    }
    var lastname by rememberSaveable {
        mutableStateOf("")
    }
    var username by rememberSaveable {
        mutableStateOf("")
    }
    var phone by rememberSaveable {
        mutableStateOf("")
    }
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var firstname by rememberSaveable {
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

    Column(
        verticalArrangement = Arrangement.spacedBy(19.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(vertical = 20.dp, horizontal = 30.dp)
    ) {
        Back(navController = navController, modifier = Modifier.align(Alignment.Start))
        Text(
            "Регистрация",
            style = MaterialTheme.typography.titleLarge.copy(MaterialTheme.colorScheme.secondary),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 10.dp)
        )
        BtnNav(navController = navController, currentRoute = currentScreen.route)
        LogoAuth(Modifier.width(90.dp))
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            FormInput(
                value = username,
                onChangeValue = { username = it },
                placeholder = "username",
                setErrorFiled = { error = it }
            )
            FormInput(value = firstname, onChangeValue = { firstname = it }, placeholder = "Имя")
            FormInput(value = lastname, onChangeValue = { lastname = it }, placeholder = "Фамилия")
            FormInput(
                value = email,
                onChangeValue = { email = it },
                placeholder = "Email",
                errorValue = "Некоректный ввод почты",
                errorCheck = Regex(InputRegex.email),
                setErrorFiled = { error = it }
            )
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
                setErrorFiled = { error = it },
                errorCheck = Regex(InputRegex.password),
                errorValue = "Пароль должен начинаться от 8 символов и содержать a-Z",
                placeholder = "Придумайте пароль"
            )
            FormInput(
                value = passwordCopy,
                onChangeValue = { passwordCopy = it },
                type = "password",
                setErrorFiled = { error = it },
                errorCheck = Regex("^$password$"),
                errorValue = "The password must match",
                placeholder = "Подтвердите пароль"
            )
            PolicyChecked(value = checkPolicy, onChange = { checkPolicy = it })
        }
        BtnBlack(text = "Продолжить", enabled = checkPolicy && error.isEmpty() && isNotEmpty(lastname,phone,email,firstname,password)) {
            CoroutineScope(Dispatchers.IO).launch {
                registration(SignUpDTO(
                    username = username,
                    email = email,
                    password = password,
                    type = SignUpDTO.Type.USER,
                    userSettings = UserSettings(
                        lastName = lastname,
                        firstName =firstname
                    ),
                    companySettings = null
                ))
            }
            //navController.navigateSingleTopTo(SendCode)
        }
    }
}