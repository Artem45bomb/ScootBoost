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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.NoCredentialException
import androidx.navigation.NavHostController
import com.example.scootboost.R
import com.example.scootboost.api.auth.oauth.handleSignInGoogle
import com.example.scootboost.api.isNotEmpty
import com.example.scootboost.component.input.FormInput
import com.example.scootboost.config.InputRegex
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.ui.btn.BtnBlack
import com.example.scootboost.ui.btn.nav.Back
import com.example.scootboost.ui.btn.sign.auth.GoogleSignButton
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
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
                    text = stringResource(R.string.text_login),
                    style = MaterialTheme.typography.titleLarge.copy(MaterialTheme.colorScheme.secondary),
                    textAlign = TextAlign.Center
                )
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    FormInput(
                        value = email,
                        onChangeValue = { email = it },
                        placeholder = stringResource(R.string.text_email),
                        errorShow = false,
                        errorValue = stringResource(R.string.error_invalid_email),
                        errorCheck = Regex(InputRegex.email),
                        setErrorFiled = { error = it })
                    FormInput(
                        value = password,
                        onChangeValue = { password = it },
                        type = "password",
                        errorShow = false,
                        placeholder = stringResource(R.string.text_password),
                        errorValue = stringResource(R.string.error_invalid_password),
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
            BtnBlack(text = stringResource(R.string.sign_btn_signin), enabled = error.isEmpty() && isNotEmpty(email,password)) {
            }
            Text(text = stringResource(R.string.text_forgot_password), textDecoration = TextDecoration.Underline)
        }
        Column {
            Text(
                text = stringResource(R.string.text_join_with),
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


