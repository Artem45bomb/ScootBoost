package com.example.scootboost.ui.btn.nav

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.scootboost.R


@Composable
fun Back(modifier: Modifier = Modifier,navController:NavHostController) {
    IconButton(modifier = modifier,onClick = { navController.popBackStack() }) {
        Icon(
            painterResource(id = R.drawable.back),
            "back icon",
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}