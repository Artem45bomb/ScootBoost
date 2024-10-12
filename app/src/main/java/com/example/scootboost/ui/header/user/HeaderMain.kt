package com.example.scootboost.ui.header.user

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scootboost.R
import com.example.scootboost.routes.RouteBase
import com.example.scootboost.ui.logo.Logo
import com.example.scootboost.ui.theme.Black_blue
import com.example.scootboost.ui.theme.ScootBoostTheme


@Composable
fun HeaderMain(modifier: Modifier = Modifier,onNavigation:(RouteBase) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(horizontal = 25.dp)

    ){
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Logo(modifier = Modifier
                .height(30.dp)
                .aspectRatio(1/1f)
            )
            IconButton(onClick = {}){
                Icon(painter = painterResource(R.drawable.ic_menu),
                contentDescription = "menu icon",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            IconButton(onClick = {}){
                Icon(
                    modifier = Modifier.padding(0.dp),
                    painter = painterResource(R.drawable.ic_world),
                    contentDescription = "world button of app",
                    tint = MaterialTheme.colorScheme.primary)
            }
            IconButton(onClick = {}){
                Icon(painter = painterResource(R.drawable.ic_question),
                    contentDescription = "button for question",
                    tint = MaterialTheme.colorScheme.primary)
            }
        }
    }
}






@Preview(showSystemUi = true)
@Composable
private fun PHeaderMain() {
    ScootBoostTheme {
        HeaderMain(onNavigation = {})
    }
}