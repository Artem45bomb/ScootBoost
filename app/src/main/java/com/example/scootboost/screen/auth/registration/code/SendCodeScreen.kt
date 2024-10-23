package com.example.scootboost.screen.auth.registration.code

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.scootboost.R
import com.example.scootboost.component.FormInput
import com.example.scootboost.data.model.UserRegistrationData
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.ui.btn.BtnBlack


@Router(route = "sendCodeScreen", groupId = ["auth"])
class SendCodeRouter : RouterType

@Composable
fun SendCodeScreen(modifier: Modifier = Modifier, navController: NavHostController,currentScreen:RouteBase) {
    var sms by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize().padding(31.dp)
    ) {
        IconButton(onClick ={navController.popBackStack()}, Modifier.align(Alignment.Start).clip(
            CircleShape
        )) {
            Icon(
                painterResource(id = R.drawable.back),
                "back icon",
                tint = MaterialTheme.colorScheme.secondary,
            )
        }
        FormInput(value = sms, onChangeValue ={sms = it}, placeholder = "код подтверждения")
        BtnBlack(text = "Продолжить", modifier = Modifier.padding(top = 19.dp)) {

        }
    }
}