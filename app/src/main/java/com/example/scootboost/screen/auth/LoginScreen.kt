package com.example.scootboost.screen.auth


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.scootboost.R
import com.example.scootboost.component.FormInput
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.ui.auth.nav.BtnNav
import com.example.scootboost.ui.btn.BtnBlack

@Router(route = "login",groupId = ["auth"])
class LoginRouter: RouterType

@Composable
fun LoginScreen(modifier: Modifier = Modifier,navController: NavHostController,currentScreen:RouteBase) {
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
        IconButton(onClick = {navController.popBackStack()}) {
            Icon(painterResource(id = R.drawable.back),"back icon", tint = MaterialTheme.colorScheme.secondary)
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
            .fillMaxWidth()){
            Column(
                verticalArrangement = Arrangement.spacedBy(22.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Вход",
                    style= MaterialTheme.typography.titleLarge.copy(MaterialTheme.colorScheme.secondary),
                    textAlign = TextAlign.Center
                )
                BtnNav(navController= navController, currentRoute = currentScreen.route)
            }
            Column(verticalArrangement =Arrangement.spacedBy(10.dp)){
                FormInput(value = email, onChangeValue = {email = it}, placeholder = "Email")
                FormInput(value = password, onChangeValue = {password = it}, type = "password", placeholder = "Пароль")
            }
            BtnBlack(text = "Продолжить") {
            }
            Text(text = "Забыли пароль", textDecoration = TextDecoration.Underline)
        }
        Spacer(modifier = Modifier.fillMaxWidth())
    }
}