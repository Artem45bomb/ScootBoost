package com.example.scootboost.screen.auth


import android.credentials.GetCredentialException
import android.os.Build
import android.util.Log
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
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.NoCredentialException
import androidx.navigation.NavHostController
import com.example.scootboost.api.auth.request.loginEmail
import com.example.scootboost.api.auth.request.loginGoogle
import com.example.scootboost.api.isNotEmpty
import com.example.scootboost.component.input.FormInput
import com.example.scootboost.config.InputRegex
import com.example.scootboost.data.model.JwtResponseDTO
import com.example.scootboost.data.model.RequestException
import com.example.scootboost.data.model.Result
import com.example.scootboost.data.model.SignInEmailDTO
import com.example.scootboost.data.model.SignInGoogleId
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.ui.btn.BtnBlack
import com.example.scootboost.ui.btn.nav.Back
import com.example.scootboost.ui.btn.sign.auth.GoogleSignButton
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.security.MessageDigest
import java.util.UUID


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

    fun login(){
        CoroutineScope(Dispatchers.IO).launch{
            try {
                val response = loginEmail(SignInEmailDTO(email, password))
                if(response is Result.Success<JwtResponseDTO>){
                    println("accessToken=${response.body.accessToken};refreshToken=${response.body.token}")
                }
            }
            catch(ex:RequestException){
                println(ex.message)
            }
        }
    }

    fun handleSignInGoogle(result: GetCredentialResponse) {
        // Handle the successfully returned credential.
        when (val credential = result.credential) {
            is CustomCredential -> {
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        // Use googleIdTokenCredential and extract id to validate and
                        // authenticate on your server.
                        val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)
                        println("google id:${googleIdTokenCredential.idToken}")
                        CoroutineScope(Dispatchers.IO).launch {
                            loginGoogle(SignInGoogleId(googleIdTokenCredential.idToken))
                        }

                        // TODO: Send [googleIdTokenCredential.idToken] to your backend
                    } catch (e: GoogleIdTokenParsingException) {
                        Log.e("MainActivity", "handleSignIn:", e)
                    }
                } else {
                    // Catch any unrecognized custom credential type here.
                    Log.e("MainActivity", "Unexpected type of credential")
                }
            }

            else -> {
                // Catch any unrecognized credential type here.
                Log.e("MainActivity", "Unexpected type of credential")
            }
        }
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
            BtnBlack(text = "Войти", enabled = error.isEmpty() && isNotEmpty(email,password), onClick = {login()})
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
                val rawNonce = UUID.randomUUID().toString()
                val bytes = rawNonce.toByteArray()
                val md = MessageDigest.getInstance("SHA-256")
                val digest = md.digest(bytes)
                val hashedNonce = digest.fold(""){str,it ->str+"%02x".format(it)}

                val credentialManager = CredentialManager.create(context)
                val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId("656212445191-ibg62nji05uh3qdsf77q4cc6k0cdlst0.apps.googleusercontent.com")
                    .setNonce(hashedNonce)
                    .build()

                val request: GetCredentialRequest = GetCredentialRequest.Builder()
                    .addCredentialOption(googleIdOption)
                    .build()



                coroutineScope.launch {
                    try {
                        val result = credentialManager.getCredential(
                            request = request,
                            context = context,
                        )
                        handleSignInGoogle(result)
                    }
                    catch (e: NoCredentialException) {
                        Log.e("CredentialManager", "No credential available", e)
                    }
                    catch (e: GetCredentialException) {
                        println("auth ${e.message.toString()}")
                    }
                }
            }
        }
    }
}


