package com.example.scootboost.screen.auth


import android.credentials.GetCredentialException
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.navigation.NavHostController
import com.example.scootboost.api.auth.oauth.handleSignInGoogle
import com.example.scootboost.component.FormInput
import com.example.scootboost.config.InputRegex
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.ui.btn.BtnBlack
import com.example.scootboost.ui.btn.nav.Back
import com.example.scootboost.ui.btn.sign.auth.GoogleSignButton
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import kotlinx.coroutines.launch


@Router(route = "login", groupId = ["auth"])
class LoginRouter : RouterType

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    currentScreen: RouteBase
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    var error by rememberSaveable {
        mutableStateOf("")
    }
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 48.dp, horizontal = 30.dp)
    ) {
        Back(navController = navController)
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Вход",
                    style = MaterialTheme.typography.titleLarge.copy(MaterialTheme.colorScheme.secondary),
                    textAlign = TextAlign.Center
                )
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    FormInput(
                        value = email,
                        onChangeValue = { email = it },
                        placeholder = "Email",
                        errorShow = false,
                        errorValue = "Некоректный ввод почты",
                        errorCheck = Regex(InputRegex.email),
                        setErrorFiled = { error = it })
                    FormInput(
                        value = password,
                        onChangeValue = { password = it },
                        type = "password",
                        errorShow = false,
                        placeholder = "Пароль",
                        errorValue = "Пароль должен начинаться от 8 символов и содержать a-Z",
                        errorCheck = Regex(InputRegex.password),
                        setErrorFiled = { error = it })
                    Text(
                        text = error,
                        style = MaterialTheme.typography.displaySmall.copy(
                            color = Color.Red,
                            fontSize = 12.sp
                        ),
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
            BtnBlack(text = "Войти", enabled = error == "") {
            }
            Text(text = "Забыли пароль", textDecoration = TextDecoration.Underline)
        }
        Column {
            Text(
                text = "присоединяйтесь с помощью:",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            )
            GoogleSignButton {
                val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId("656212445191-t8ep9v29lors27f2rk47as80genf2c06.apps.googleusercontent.com")
                    .build()

                val request: GetCredentialRequest = GetCredentialRequest.Builder()
                    .addCredentialOption(googleIdOption)
                    .build()
                val credentialManager = CredentialManager.create(context)

                coroutineScope.launch {
                    try {
                        val result = credentialManager.getCredential(
                            request = request,
                            context = context,
                        )
                        handleSignInGoogle(result)
                    } catch (e: GetCredentialException) {
                        println("auth ${e.message.toString()}")
                    }
                }
            }
        }
    }
}


