package com.example.scootboost.ui.auth.nav

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.scootboost.data.navigateSingleTopTo
import com.example.scootboost.routes.Registration
import com.example.scootboost.routes.RegistrationCompany


@Composable
fun BtnNav(modifier: Modifier = Modifier,navController: NavHostController,currentRoute:String) {
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier =Modifier.fillMaxWidth()) {
                BtnNavItem(
                    shape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp),
                    text = "Пользователь",
                    isActive = currentRoute == Registration.route,

                ) {
                    navController.navigateSingleTopTo(Registration.route)
                }
                BtnNavItem(
                    shape = RoundedCornerShape(topEnd = 20.dp, bottomEnd = 20.dp),
                    text = "Компания",
                    isActive = currentRoute != Registration.route,
                ) {
                    navController.navigateSingleTopTo(RegistrationCompany.route)
                }
        }
        Row (verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.spacedBy(7.dp), modifier = Modifier.padding(top = 19.dp)){
            Circle(isActive = currentRoute == Registration.route)
            Circle(isActive = currentRoute != Registration.route)
        }
    }

}


@Composable
fun Circle(modifier: Modifier = Modifier,isActive: Boolean){
    val size by animateDpAsState(if(isActive) 10.dp else 5.dp, label = "size")

    Box(
        modifier
            .height(size)
            .aspectRatio(1 / 1f)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondary)){}
}

@Composable
fun RowScope.BtnNavItem(modifier: Modifier = Modifier,text:String,isActive:Boolean,shape:Shape,onClick:() -> Unit) {
    val background by animateColorAsState(if (isActive) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary, label = "color")
    val textColor by animateColorAsState(if (isActive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary, label = "color")

    Button(
        contentPadding = PaddingValues(0.dp),
        shape = shape,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = background
        ),
        modifier = modifier
            .weight(1f)
    ) {
        Text(text,style = MaterialTheme.typography.displayMedium.copy(color = textColor), textAlign = TextAlign.Center)
    }
}


@Preview(showSystemUi = true)
@Composable
private fun PBtnNav() {
}