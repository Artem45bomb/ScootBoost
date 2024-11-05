package com.example.scootboost.screen.auth.registration.code

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.scootboost.R
import com.example.scootboost.component.input.FormCode
import com.example.scootboost.component.input.FormInput
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.ui.btn.BtnBlack


@Router(route = "sendCodeScreen/{userId}", groupId = ["auth"])
class SendCodeRouter : RouterType

@Composable
fun SendCodeScreen(modifier: Modifier = Modifier,userId:Int,navController: NavHostController,currentScreen:RouteBase) {
    var code by rememberSaveable {
        mutableStateOf("    ")
    }
    var isError by rememberSaveable {
        mutableStateOf(false)
    }
    println(userId)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(57.dp),
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
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(17.dp)){
            Text("Введите код подтверждения:",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.secondary),
                modifier = Modifier.padding(bottom = 40.dp)
            )
            FormCode(code= code, isError=isError) {code =it}
            BtnBlack(text = "Продолжить", modifier = Modifier.padding(top = 19.dp)) {
                isError = !isError
            }

            Text(
                "Повторно отправить код",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.clickable {

                }
            )


        }

    }
}