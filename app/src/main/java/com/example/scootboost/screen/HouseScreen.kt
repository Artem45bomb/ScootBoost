package com.example.scootboost.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.scootboost.R
import com.example.scootboost.data.navigateSingleTopTo
import com.example.scootboost.routes.Login
import com.example.scootboost.routes.Registration
import com.example.scootboost.routes.Router
import com.example.scootboost.routes.RouterType
import com.example.scootboost.routes.SendCode
import com.example.scootboost.ui.btn.BtnLight
import com.example.scootboost.ui.logo.Logo
import com.example.scootboost.ui.theme.Modak

@Router(route = "house", groupId = ["auth"])
class HouseRouter : RouterType

@Composable
fun HouseScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(modifier) {
        Image(
            painter = painterResource(R.drawable.house_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 30.dp, bottom = 30.dp)
                .fillMaxSize()
        ) {
            Spacer(Modifier.height(0.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()){
                with(MaterialTheme) {
                    Text(
                        text = "ScootBoost ®",
                        style = typography.headlineLarge.copy(
                            colorScheme.secondary,
                            fontFamily = Modak
                        ),
                    )
                }
                Logo(Modifier
                    .fillMaxWidth(0.69f)
                    .border(1.dp,MaterialTheme.colorScheme.secondary, CircleShape)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth(0.69f)
            ) {
                BtnLight(text = "Войти") {
                    navController.navigateSingleTopTo(Login.route)
                }
                BtnLight(text = "Зарегистрироваться") {
                    navController.navigateSingleTopTo(Registration.route)
                }
                BtnLight(text = "Продолжить без входа") {
                    navController.navigateSingleTopTo(SendCode.route)
                }
            }

        }
    }
}
